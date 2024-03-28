package com.sofka.model.bank_account;

import java.util.Date;

public class BankAccount {
    private String idAccount;
    private String transactionType;
    private double amount;
    private double transactionCost;
    private Date dateTransaction;

    public BankAccount(String idAccount, String transactionType, double amount, double transactionCost, Date dateTransaction) {
        this.idAccount = idAccount;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionCost = transactionCost;
        this.dateTransaction = dateTransaction;
    }

    public BankAccount(){}
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
