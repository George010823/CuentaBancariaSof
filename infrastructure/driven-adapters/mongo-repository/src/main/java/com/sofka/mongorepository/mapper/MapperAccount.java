package com.sofka.mongorepository.mapper;

import com.sofka.model.bank_account.BankAccount;
import com.sofka.mongorepository.AccountDocument;
import com.sofka.mongorepository.data.BankAccountData;
import org.springframework.stereotype.Component;

@Component
public class MapperAccount {
    public BankAccount toAccountModel(AccountDocument accountDocument){
        return new BankAccount(
                accountDocument.getId(),
                accountDocument.getBalance(),
                accountDocument.getMambuAccountId()
        );
    }

    public AccountDocument toAccountEntity(BankAccount accountModel){
        return new AccountDocument(
                null,
                accountModel.getAmount(),
                accountModel.getMambuAccountId()
        );
    }
}
