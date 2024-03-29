package com.sofka.usecase.account;

import com.sofka.model.bank_account.BankAccount;
import com.sofka.model.bank_account.gateways.BankAccountGateway;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class FindAccountByIdUseCase implements Function<String, Mono<BankAccount>> {
    private final BankAccountGateway accountGateway;

    public FindAccountByIdUseCase(BankAccountGateway accountGateway){
        this.accountGateway = accountGateway;
    }

    @Override
    public Mono<BankAccount> apply(String accountId) {

        return accountGateway.findById(accountId);
    }
}