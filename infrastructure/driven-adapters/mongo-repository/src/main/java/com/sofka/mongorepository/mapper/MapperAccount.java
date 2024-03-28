package com.sofka.mongorepository.mapper;

import com.sofka.model.bank_account.BankAccount;
import com.sofka.mongorepository.data.BankAccountData;
import org.springframework.stereotype.Component;

@Component
public class MapperAccount {
    public BankAccount toAccountModel(BankAccountData accountDocument){
        return new BankAccount(
                accountDocument.getIdAccount(),
                accountDocument.getTransactionType(),
                accountDocument.getAmount(),
                accountDocument.getTransactionCost(),
                accountDocument.getDateTransaction()
        );
    }

    public BankAccountData toAccountEntity(BankAccount accountModel){
        return new BankAccountData(
                null,
                accountModel.getTransactionType(),
                accountModel.getAmount(),
                accountModel.getTransactionCost(),
                accountModel.getDateTransaction()
        );
    }
}
