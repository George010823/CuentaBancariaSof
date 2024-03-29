package com.sofka.mongorepository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionMongoRepository extends ReactiveMongoRepository<TransactionDocument, String> {
}
