package com.sofka.model.dto;

import com.sofka.model.enums.CHANNEL;
import com.sofka.model.enums.TYPE;

import java.util.Date;

public class UpdateBalanceDTO {
    private String idAccount;
    //private String transactionType;
    private double amount;
    //private double transactionCost;
    //private Date dateTransaction;
    private TYPE type;
    private CHANNEL channel;

    public UpdateBalanceDTO() {
    }

    public UpdateBalanceDTO(String idAccount, double amount, Date dateTransaction) {
        this.idAccount = idAccount;
        //this.transactionType = transactionType;
        this.amount = amount;
        //this.transactionCost = transactionCost;
        //this.dateTransaction = dateTransaction;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public CHANNEL getChannel() {
        return channel;
    }

    public void setChannel(CHANNEL channel) {
        this.channel = channel;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

//    public String getTransactionType() {
//        return transactionType;
//    }
//
//    public void setTransactionType(String transactionType) {
//        this.transactionType = transactionType;
//    }
//
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

//    public double getTransactionCost() {
//        return transactionCost;
//    }
//
//    public void setTransactionCost(double transactionCost) {
//        this.transactionCost = transactionCost;
//    }

//    public Date getDateTransaction() {
//        return dateTransaction;
//    }
//
//    public void setDateTransaction(Date dateTransaction) {
//        this.dateTransaction = dateTransaction;
//    }

    @Override
    public String toString() {
        return "UpdateBalanceDTO{" +
                "idAccount='" + idAccount + '\'' +
                ", amount=" + amount +
                ", type=" + type +
                ", channel=" + channel +
                '}';
    }
}
