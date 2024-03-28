package com.sofka.usecase.account;

import com.sofka.model.bank_account.BankAccount;
import com.sofka.model.bank_account.gateways.BankAccountGateway;
import reactor.core.publisher.Mono;
import java.util.function.BiFunction;

public class UpdateTransactionUseCase implements BiFunction<String, BankAccount, Mono<BankAccount>> {

    private final BankAccountGateway bankAccountGateway;
    public UpdateTransactionUseCase(BankAccountGateway bankAccountGateway) {
        this.bankAccountGateway = bankAccountGateway;
    }

    public Mono<BankAccount> apply(String idAccount, BankAccount bankAccount) {
        return bankAccountGateway.updateTransaction(idAccount, bankAccount);
    }
}
