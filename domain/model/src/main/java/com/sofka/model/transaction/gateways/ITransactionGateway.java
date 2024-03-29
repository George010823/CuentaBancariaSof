package com.sofka.model.transaction.gateways;

import com.sofka.model.transaction.TransactionModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionGateway {
    Mono<TransactionModel> create(TransactionModel transactionModel);

    Flux<TransactionModel> getAll();
}
