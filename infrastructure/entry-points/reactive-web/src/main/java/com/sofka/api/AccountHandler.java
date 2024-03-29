package com.sofka.api;

import com.sofka.api.wrapper.ResponseWrapper;
import com.sofka.model.Header;
import com.sofka.model.TransactionDetails;
import com.sofka.model.bank_account.BankAccount;
import com.sofka.model.dto.UpdateBalanceDTO;
import com.sofka.model.enums.TypeValueTransaction;
import com.sofka.model.mambu.retiro.MambuResponseAccountBalanceInfo;
import com.sofka.model.mambu.retiro.MambuTrxCnlCashDepFields;
import com.sofka.model.mambu.retiro.RequestRetiro;
import com.sofka.model.mambu.retiro.ResponseRetiro;
import com.sofka.model.transaction.TransactionModel;
import com.sofka.usecase.account.UpdateTransactionUseCase;
import com.sofka.usecase.account.CreateAccountUseCase;
import com.sofka.usecase.account.FindAccountByIdUseCase;
import com.sofka.usecase.mambu.MambuCreateWithDrawalTransactionUseCase;
import com.sofka.usecase.mambu.MambuGetAccountBalanceUseCase;
import com.sofka.usecase.mambu.UpdateAccountBalanceHelper;
import com.sofka.usecase.mambu.UpdateAccountBalanceUseCase;
import com.sofka.usecase.transaction.CreateTransactionUseCase;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

@Component
public class AccountHandler {

    private final CreateAccountUseCase createAccountUseCase;
    private final FindAccountByIdUseCase findAccountByIdUseCase;
    private final UpdateTransactionUseCase updateTransactionUseCase;
    private final MambuGetAccountBalanceUseCase mambuGetAccountBalanceUseCase;
    private final UpdateAccountBalanceUseCase updateAccountBalanceUseCase;
    private final CreateTransactionUseCase createTransactionUseCase;
    private final MambuCreateWithDrawalTransactionUseCase mambuCreateWithDrawalTransactionUseCase;


    public AccountHandler(CreateAccountUseCase createAccountUseCase, FindAccountByIdUseCase findAccountByIdUseCase, UpdateTransactionUseCase atmDepositUseCase, UpdateTransactionUseCase updateTransactionUseCase, Validator validator, ObjectMapper objectMapper, MambuGetAccountBalanceUseCase mambuGetAccountBalanceUseCase, UpdateAccountBalanceUseCase updateAccountBalanceUseCase, CreateTransactionUseCase createTransactionUseCase, MambuCreateWithDrawalTransactionUseCase mambuCreateWithDrawalTransactionUseCase) {
        this.createAccountUseCase = createAccountUseCase;
        this.findAccountByIdUseCase = findAccountByIdUseCase;
        this.updateTransactionUseCase = updateTransactionUseCase;
        this.mambuGetAccountBalanceUseCase = mambuGetAccountBalanceUseCase;
        this.updateAccountBalanceUseCase = updateAccountBalanceUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.mambuCreateWithDrawalTransactionUseCase = mambuCreateWithDrawalTransactionUseCase;
    }

    public Mono<ServerResponse> createAccount(ServerRequest request) {
        return request.bodyToMono(BankAccount.class)
                .flatMap(accountModel -> createAccountUseCase.apply(accountModel)
                        .flatMap(data -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(new ResponseWrapper<>("Account created successfully", data))
                        )
                        .onErrorResume(exception -> ServerResponse.status(HttpStatus.BAD_REQUEST)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(new ResponseWrapper<>(exception.getMessage(), null))
                        )
                );
    }
    public Mono<ServerResponse> getAccountById(ServerRequest request) {
        String id = request.queryParam("id").orElse(null);
        if (id == null) {
            return ServerResponse.badRequest().bodyValue(new ResponseWrapper<>("ID parameter is required", null));
        }
        return findAccountByIdUseCase.apply(id)
                .flatMap(data -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(new ResponseWrapper<>("Account found", data)))
                .onErrorResume(exception -> ServerResponse.status(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(new ResponseWrapper<>(exception.getMessage(), null))
                );
    }
    public Mono<ServerResponse> updateTransaction(ServerRequest request) {
        String id = request.queryParam("id").orElse(null);
        if (id == null) {
            return ServerResponse.badRequest().bodyValue(new ResponseWrapper<>("ID parameter is required", null));
        }
        return request.bodyToMono(UpdateBalanceDTO.class)
                .flatMap(updateBalanceDTO -> {
                    return findAccountByIdUseCase.apply(id)
                            .flatMap(account -> {
                                double currentAmount = account.getAmount();
                                //double newAmount = calculateNewAmount(currentAmount, updateBalanceDTO);
                                //String transactionType = updateBalanceDTO.getTransactionType();
                                //double transactionCost = getTransactionCost(transactionType);

                                //account.setAmount(newAmount);
                                //account.setTransactionType(transactionType);
                                //account.setTransactionCost(transactionCost);

                                // Llamar al caso de uso para actualizar la cuenta con el nuevo saldo
                                return updateTransactionUseCase.apply(id, account)
                                        .flatMap(updatedBankAccount -> ServerResponse.ok()
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .bodyValue(new ResponseWrapper<>("Transaction updated successfully", updatedBankAccount))
                                        );
                            })
                            .switchIfEmpty(ServerResponse.notFound().build());
                })
                .onErrorResume(exception -> ServerResponse.status(HttpStatus.BAD_REQUEST)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(new ResponseWrapper<>(exception.getMessage(), null))
                );
    }

//    public Mono<ServerResponse> updateAccountBalance(ServerRequest request) {
//        return request.bodyToMono(UpdateBalanceDTO.class)
//                .flatMap(this::findMambuAccountId)
//                .onErrorResume(exception -> ServerResponse.status(HttpStatus.NOT_FOUND)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .bodyValue(new ResponseWrapper<>(exception.getMessage(), null))
//                );
//    }
//
//    private Mono<ServerResponse> findMambuAccountId(UpdateBalanceDTO updateBalanceDTO) {
//        return findAccountByIdUseCase.apply(updateBalanceDTO.getIdAccount())
//                .flatMap(accountModel -> this.getMambuAccountBalance(accountModel, updateBalanceDTO));
//    }
//
//    private Mono<ServerResponse> getMambuAccountBalance(BankAccount accountModel, UpdateBalanceDTO updateBalanceDTO) {
//        return mambuGetAccountBalanceUseCase.apply(accountModel.getMambuAccountId())
//                .flatMap(mambuResponseAccountBalanceInfo -> this.createWithDrawalTransactionCashOut(mambuResponseAccountBalanceInfo, updateBalanceDTO, accountModel));
//    }
//
//    private Mono<ServerResponse> createWithDrawalTransactionCashOut(MambuResponseAccountBalanceInfo mambuResponseAccountBalanceInfo, UpdateBalanceDTO updateBalanceDTO, BankAccount accountModel) {
//        double tax = UpdateAccountBalanceHelper.getTransactionTax(updateBalanceDTO);
//        double newBalance = UpdateAccountBalanceHelper.getTransactionNewBalance(mambuResponseAccountBalanceInfo, updateBalanceDTO, tax);
//
//        if (newBalance < 0) {
//            return Mono.error(new RuntimeException("Insufficient funds"));
//        }
//
//        RequestRetiro mambuRequestBodyCashOutDTO =
//                this.buildNewCashOutRequestBody(updateBalanceDTO, tax, "TRXCNL-CASHOUT");
//
//        return mambuCreateWithDrawalTransactionUseCase
//                .apply(mambuRequestBodyCashOutDTO, accountModel.getMambuAccountId())
//                .flatMap(mambuResponseCashOutDTO -> this.createWithDrawalTransactionCommission(mambuResponseCashOutDTO, updateBalanceDTO, accountModel));
//    }

    public Mono<ServerResponse> updateAccountBalance(ServerRequest request) {
        return request.bodyToMono(UpdateBalanceDTO.class)
                .flatMap(updateBalanceDTO -> findAccountByIdUseCase.apply(updateBalanceDTO.getIdAccount())
                        .flatMap(accountModel -> mambuGetAccountBalanceUseCase.apply(accountModel.getMambuAccountId())
                                .flatMap(mambuResponseAccountBalanceInfo -> {
                                    double tax = UpdateAccountBalanceHelper.getTransactionTax(updateBalanceDTO);
                                    double newBalance = UpdateAccountBalanceHelper.getTransactionNewBalance(mambuResponseAccountBalanceInfo, updateBalanceDTO, tax);

                                    if (newBalance < 0) {
                                        return Mono.error(new RuntimeException("Insufficient funds"));
                                    }

                                    RequestRetiro mambuRequestBodyCashOutDTO =
                                            buildNewCashOutRequestBody(updateBalanceDTO, tax, "TRXCNL-CASHOUT");

                                    return mambuCreateWithDrawalTransactionUseCase
                                            .apply(mambuRequestBodyCashOutDTO, accountModel.getMambuAccountId())
                                            .flatMap(mambuResponseCashOutDTO -> createWithDrawalTransactionCommission(mambuResponseCashOutDTO, updateBalanceDTO, accountModel));
                                })
                        )
                )
                .onErrorResume(exception -> ServerResponse.status(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(new ResponseWrapper<>(exception.getMessage(), null))
                );
    }

    private Mono<ServerResponse> createWithDrawalTransactionCommission(ResponseRetiro mambuResponseCashOutDTO, UpdateBalanceDTO updateBalanceDTO, BankAccount accountModel) {
        double tax = UpdateAccountBalanceHelper.getTransactionTax(updateBalanceDTO);

        RequestRetiro mambuRequestBodyCommissionDTO =
                buildNewCashOutRequestBody(updateBalanceDTO, tax, "TRXCNL-COMMISSION");

        return mambuCreateWithDrawalTransactionUseCase
                .apply(mambuRequestBodyCommissionDTO, accountModel.getMambuAccountId())
                .flatMap(mambuResponseCommissionDTO ->
                        this.updateMongoBalanceAndCreateMongoTransaction(mambuResponseCommissionDTO, updateBalanceDTO, mambuResponseCashOutDTO, accountModel.getMambuAccountId())
                );
    }


    private Mono<ServerResponse> updateMongoBalanceAndCreateMongoTransaction(ResponseRetiro mambuResponseCommissionDTO, UpdateBalanceDTO updateBalanceDTO, ResponseRetiro mambuResponseCashOutDTO, String mambuAccountId) {
        return updateAccountBalanceUseCase.apply(
                        updateBalanceDTO.getIdAccount(),
                        mambuResponseCommissionDTO.getAccountBalances().getTotalBalance()
                )
                .then(createTransactionUseCase.apply(
                        new TransactionModel(
                                null,
                                updateBalanceDTO.getType(),
                                updateBalanceDTO.getChannel(),
                                UpdateAccountBalanceHelper.getTransactionTax(updateBalanceDTO),
                                updateBalanceDTO.getIdAccount(),
                                mambuResponseCommissionDTO.getAccountBalances().getTotalBalance(),
                                mambuResponseCommissionDTO.getCreationDate(),
                                -mambuResponseCashOutDTO.getAmount(),
                                mambuAccountId,
                                mambuResponseCashOutDTO.getParentAccountKey()
                        )
                ))
                .flatMap(transaction -> ServerResponse.status(HttpStatus.CREATED)
                        .bodyValue(new ResponseWrapper<>("Successful transaction", transaction))
                );
    }

    private RequestRetiro buildNewCashOutRequestBody(UpdateBalanceDTO updateBalanceDTO, Double transactionValue, String mambuTransactionType) {
        TransactionDetails transactionDetailsRequest = new TransactionDetails(mambuTransactionType);
        MambuTrxCnlCashDepFields trxCnlCashDepFieldsRequest = null;

        if ("TRXCNL-CASHOUT".equals(mambuTransactionType)) {
            String randomUUID1 = UUID.randomUUID().toString();
            String randomUUID2 = UUID.randomUUID().toString();

            trxCnlCashDepFieldsRequest = new MambuTrxCnlCashDepFields(
                    randomUUID1,
                    "125.34.96.48"
            );

            return new RequestRetiro(
                    transactionValue,
                    transactionDetailsRequest,
                    trxCnlCashDepFieldsRequest,
                    null,
                    randomUUID2,
                    updateBalanceDTO.getType().toString() + "_" + updateBalanceDTO.getChannel().toString()
            );
        }

        return new RequestRetiro(
                transactionValue,
                transactionDetailsRequest,
                trxCnlCashDepFieldsRequest,
                null,
                null,
                updateBalanceDTO.getType().toString() + "_" + updateBalanceDTO.getChannel().toString()
        );
    }


    private double getTransactionCost(String transactionType) {
        TypeValueTransaction typeTransaction = TypeValueTransaction.obtenerTipoTransaccion(transactionType);
        if (typeTransaction == null) {
            throw new RuntimeException("Invalid transaction type: " + transactionType);
        }
        return typeTransaction.getValor();
    }

//    private double calculateNewAmount(double currentAmount, UpdateBalanceDTO updateBalanceDTO) {
//        TypeValueTransaction typeTransaction = TypeValueTransaction.obtenerTipoTransaccion(updateBalanceDTO.getTransactionType());
//        if (typeTransaction == null) {
//            throw new RuntimeException("Invalid transaction type: " + updateBalanceDTO.getTransactionType());
//        }
//        double transactionCost = typeTransaction.getValor();
//        double transactionAmount = updateBalanceDTO.getAmount();
//        return switch (typeTransaction) {
//            case DEPOSITO_SUCURSAL, DEPOSITO_CAJERO, DEPOSITO_OTRA_CUENTA ->
//                    currentAmount + transactionAmount - transactionCost;
//            case COMPRA_FISICO, COMPRA_WEB, RETIRO_CAJERO ->
//                    currentAmount - transactionAmount - transactionCost;
//            default -> throw new RuntimeException("Invalid transaction type: " + typeTransaction);
//        };
//    }
}
