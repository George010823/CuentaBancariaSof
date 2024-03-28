package com.sofka.model.bank_account.gateways;

import com.sofka.model.bank_account.BankAccount;
import reactor.core.publisher.Mono;
public interface BankAccountGateway {

    Mono<BankAccount> create(BankAccount bankAccount);
    Mono<BankAccount> findById(String accountId);
    Mono<BankAccount> updateTransaction(String idAccount, BankAccount bankAccount);
}
