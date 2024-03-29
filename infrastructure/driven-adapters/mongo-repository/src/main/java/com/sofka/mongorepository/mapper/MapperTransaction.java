package com.sofka.mongorepository.mapper;

import com.sofka.model.transaction.TransactionModel;
import com.sofka.mongorepository.TransactionDocument;
import org.springframework.stereotype.Component;

@Component
public class MapperTransaction {
    public TransactionModel toTransactionModel(TransactionDocument transactionDocument){
        return new TransactionModel(
                transactionDocument.getId(),
                transactionDocument.getType(),
                transactionDocument.getChannel(),
                transactionDocument.getTax(),
                transactionDocument.getAccountId(),
                transactionDocument.getNewBalance(),
                transactionDocument.getCreatedAt(),
                transactionDocument.getTransactionValue(),
                transactionDocument.getMambuAccountId(),
                transactionDocument.getMambuParentAccountKey()
        );
    }

    public TransactionDocument toTransactionEntity(TransactionModel transactionModel){
        return new TransactionDocument(
                transactionModel.getId(),
                transactionModel.getType(),
                transactionModel.getChannel(),
                transactionModel.getTax(),
                transactionModel.getAccountId(),
                transactionModel.getNewBalance(),
                transactionModel.getCreatedAt(),
                transactionModel.getTransactionValue(),
                transactionModel.getMambuAccountId(),
                transactionModel.getMambuParentAccountKey()
        );
    }
}
