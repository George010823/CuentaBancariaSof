package com.sofka.mongorepository;

import com.sofka.model.bank_account.BankAccount;
import com.sofka.model.bank_account.gateways.BankAccountGateway;
import com.sofka.model.enums.TypeValueTransaction;
import com.sofka.mongorepository.mapper.MapperAccount;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.Date;

@Repository
@RequiredArgsConstructor
public class MongoBankAccountRepositoryAdapter implements BankAccountGateway {

    private final MongoAccountDBRepository accountRepository;
    private final MapperAccount mapperAccount;

    @Override
    public Mono<BankAccount> create(BankAccount bankAccount) {
        return accountRepository
                .save(mapperAccount.toAccountEntity(bankAccount))
                .map(mapperAccount::toAccountModel);
    }

    @Override
    public Mono<BankAccount> findById(String accountId) {
        return accountRepository.findById(accountId)
                .switchIfEmpty(Mono.error(new Throwable("Account id not found")))
                .map(mapperAccount::toAccountModel);
    }
    @Override
    @Transactional
    public Mono<BankAccount> updateTransaction(String idAccount, BankAccount bankAccount) {
        return accountRepository
                .findById(idAccount)
                .switchIfEmpty(Mono.error(new RuntimeException("Could not find account for id: " + idAccount)))
                .flatMap(bankAccountData -> {
                    String transactionType = bankAccount.getTransactionType();
                    double currentAmount = bankAccount.getAmount();
                    double transactionCost = bankAccount.getTransactionCost();
                    bankAccountData.setTransactionType(transactionType);
                    bankAccountData.setAmount(currentAmount);
                    bankAccountData.setTransactionCost(transactionCost);
                    return accountRepository.save(bankAccountData)
                            .map(mapperAccount::toAccountModel);
                });
    }
}
