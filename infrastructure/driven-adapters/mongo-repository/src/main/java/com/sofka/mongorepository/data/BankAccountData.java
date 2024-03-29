package com.sofka.mongorepository.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "transactions")
public class BankAccountData {

    @Id
    private String idAccount;
    private String transactionType;
    private double amount;
    private double transactionCost;
    private Date dateTransaction;
    private String mambuAccountId;

    public BankAccountData(String idAccount, String transactionType, double amount, double transactionCost, Date dateTransaction, String mambuAccountId) {
        this.idAccount = idAccount;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionCost = transactionCost;
        this.dateTransaction = dateTransaction;
        this.mambuAccountId = mambuAccountId;
    }
    public String getMambuAccountId() {
        return mambuAccountId;
    }

    public void setMambuAccountId(String mambuAccountId) {
        this.mambuAccountId = mambuAccountId;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTransactionCost() {
        return transactionCost;
    }

    public void setTransactionCost(double transactionCost) {
        this.transactionCost = transactionCost;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }
}
