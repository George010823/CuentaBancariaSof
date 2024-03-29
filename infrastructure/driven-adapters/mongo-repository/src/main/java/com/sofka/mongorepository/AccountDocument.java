package com.sofka.mongorepository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactions")
public class AccountDocument {
    @Id
    private String id;

    private Double amount;

    private String mambuAccountId;


    public AccountDocument(String id, Double amount, String mambuAccountId){
        this.id = id;
        this.amount = amount;
        this.mambuAccountId = mambuAccountId;
    }

    public AccountDocument(){
    }

    public String getMambuAccountId() {
        return mambuAccountId;
    }

    public void setMambuAccountId(String mambuAccountId) {
        this.mambuAccountId = mambuAccountId;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public Double getBalance(){
        return amount;
    }

    public void setBalance(Double balance){
        this.amount = balance;
    }
}
