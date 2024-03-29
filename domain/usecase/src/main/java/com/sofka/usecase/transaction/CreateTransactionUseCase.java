package com.sofka.usecase.transaction;

import com.sofka.model.transaction.TransactionModel;
import com.sofka.model.transaction.gateways.ITransactionGateway;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class CreateTransactionUseCase implements Function<TransactionModel, Mono<TransactionModel>> {
    private final ITransactionGateway transactionGateway;

    public CreateTransactionUseCase(ITransactionGateway transactionGateway){
        this.transactionGateway = transactionGateway;
    }

    @Override
    public Mono<TransactionModel> apply(TransactionModel transactionModel) {
        return transactionGateway.create(transactionModel);
    }
}
