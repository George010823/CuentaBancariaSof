package com.sofka.mongorepository;

import com.sofka.mongorepository.data.BankAccountData;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface MongoAccountDBRepository extends  ReactiveMongoRepository<BankAccountData, String> {

}
