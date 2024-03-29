package com.sofka.usecase.account;

import com.sofka.model.bank_account.BankAccount;
import com.sofka.model.bank_account.gateways.BankAccountGateway;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class CreateAccountUseCase implements Function<BankAccount, Mono<BankAccount>> {

    private final BankAccountGateway accountGateway;

    public CreateAccountUseCase(BankAccountGateway accountGateway){
        this.accountGateway = accountGateway;
    }

    @Override
    public Mono<BankAccount> apply(BankAccount accountModel) {
        return null;
//                Mono.just(accountModel)
//                .filter(model -> model.getAmount() >= 0)
//                .switchIfEmpty(Mono.error(new RuntimeException("Balance cannot be negative")))
//                .flatMap(accountGateway::create);
    }
}
