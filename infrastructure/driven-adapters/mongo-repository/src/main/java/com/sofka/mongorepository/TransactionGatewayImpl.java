package com.sofka.mongorepository;

import com.sofka.model.transaction.TransactionModel;
import com.sofka.model.transaction.gateways.ITransactionGateway;
import com.sofka.mongorepository.mapper.MapperTransaction;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public class TransactionGatewayImpl implements ITransactionGateway {
    private final MapperTransaction mapperTransaction;
    private final TransactionMongoRepository transactionMongoRepository;

    public TransactionGatewayImpl(MapperTransaction mapperTransaction, TransactionMongoRepository transactionMongoRepository){
        this.mapperTransaction = mapperTransaction;
        this.transactionMongoRepository = transactionMongoRepository;
    }

    @Override
    public Mono<TransactionModel> create(TransactionModel transactionModel){
        return transactionMongoRepository.save(mapperTransaction.toTransactionEntity(transactionModel))
                .map(mapperTransaction::toTransactionModel);
    }

    @Override
    public Flux<TransactionModel> getAll() {
        return transactionMongoRepository.findAll()
                .map(mapperTransaction::toTransactionModel);
    }
}
