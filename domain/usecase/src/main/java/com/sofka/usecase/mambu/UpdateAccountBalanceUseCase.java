package com.sofka.usecase.mambu;

import com.sofka.model.bank_account.BankAccount;
import com.sofka.model.bank_account.gateways.BankAccountGateway;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

public class UpdateAccountBalanceUseCase implements BiFunction<String, Double, Mono<BankAccount>> {
    private final BankAccountGateway accountGateway;

    public UpdateAccountBalanceUseCase(BankAccountGateway accountGateway){
        this.accountGateway = accountGateway;
    }

    @Override
    public Mono<BankAccount> apply(String accountId, Double newBalance) {
        return Mono.just(newBalance)
                .flatMap(balance -> {
                    if (balance >= 0) {
                        return accountGateway.updateBalance(accountId, newBalance);
                    } else {
                        return Mono.error(new RuntimeException("Insufficient funds"));
                    }
                });
    }
}
