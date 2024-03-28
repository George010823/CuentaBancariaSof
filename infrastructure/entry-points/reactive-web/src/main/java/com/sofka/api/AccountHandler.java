package com.sofka.api;

import com.sofka.api.wrapper.ResponseWrapper;
import com.sofka.model.bank_account.BankAccount;
import com.sofka.model.dto.UpdateBalanceDTO;
import com.sofka.model.enums.TypeValueTransaction;
import com.sofka.usecase.account.UpdateTransactionUseCase;
import com.sofka.usecase.account.CreateAccountUseCase;
import com.sofka.usecase.account.FindAccountByIdUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
public class AccountHandler {

    private final CreateAccountUseCase createAccountUseCase;
    private final FindAccountByIdUseCase findAccountByIdUseCase;
    private final UpdateTransactionUseCase updateTransactionUseCase;

    public AccountHandler(CreateAccountUseCase createAccountUseCase, FindAccountByIdUseCase findAccountByIdUseCase, UpdateTransactionUseCase atmDepositUseCase, UpdateTransactionUseCase updateTransactionUseCase) {
        this.createAccountUseCase = createAccountUseCase;
        this.findAccountByIdUseCase = findAccountByIdUseCase;
        this.updateTransactionUseCase = updateTransactionUseCase;
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
                                double newAmount = calculateNewAmount(currentAmount, updateBalanceDTO);
                                String transactionType = updateBalanceDTO.getTransactionType();
                                double transactionCost = getTransactionCost(transactionType);

                                account.setAmount(newAmount);
                                account.setTransactionType(transactionType);
                                account.setTransactionCost(transactionCost);

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

    private double getTransactionCost(String transactionType) {
        TypeValueTransaction typeTransaction = TypeValueTransaction.obtenerTipoTransaccion(transactionType);
        if (typeTransaction == null) {
            throw new RuntimeException("Invalid transaction type: " + transactionType);
        }
        return typeTransaction.getValor();
    }
    private double calculateNewAmount(double currentAmount, UpdateBalanceDTO updateBalanceDTO) {
        TypeValueTransaction typeTransaction = TypeValueTransaction.obtenerTipoTransaccion(updateBalanceDTO.getTransactionType());
        if (typeTransaction == null) {
            throw new RuntimeException("Invalid transaction type: " + updateBalanceDTO.getTransactionType());
        }
        double transactionCost = typeTransaction.getValor();
        double transactionAmount = updateBalanceDTO.getAmount();
        return switch (typeTransaction) {
            case DEPOSITO_SUCURSAL, DEPOSITO_CAJERO, DEPOSITO_OTRA_CUENTA ->
                    currentAmount + transactionAmount - transactionCost;
            case COMPRA_FISICO, COMPRA_WEB, RETIRO_CAJERO ->
                    currentAmount - transactionAmount - transactionCost;
            default -> throw new RuntimeException("Invalid transaction type: " + typeTransaction);
        };
    }
}
