package com.sofka.model.transaction;

import com.sofka.model.enums.CHANNEL;
import com.sofka.model.enums.TYPE;

public class TransactionModel {
    private String id;
    private TYPE type;
    private CHANNEL channel;
    private Double tax;
    private String accountId;

    private Double transactionValue;

    private Double newBalance;

    private String createdAt;

    private String mambuAccountId;

    private String mambuParentAccountKey;

    public TransactionModel(){
    }

    public TransactionModel(String id, TYPE type, CHANNEL channel, Double tax, String accountId, Double newBalance, String createdAt, Double transactionValue, String mambuAccountId, String mambuParentAccountKey){
        this.id = id;
        this.type = type;
        this.channel = channel;
        this.tax = tax;
        this.accountId = accountId;
        this.createdAt = createdAt;
        this.newBalance = newBalance;
        this.transactionValue = transactionValue;
        this.mambuAccountId = mambuAccountId;
        this.mambuParentAccountKey = mambuParentAccountKey;
    }

    public String getMambuParentAccountKey() {
        return mambuParentAccountKey;
    }

    public void setMambuParentAccountKey(String mambuParentAccountKey) {
        this.mambuParentAccountKey = mambuParentAccountKey;
    }

    public String getMambuAccountId() {
        return mambuAccountId;
    }

    public void setMambuAccountId(String mambuAccountId) {
        this.mambuAccountId = mambuAccountId;
    }

    public Double getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(Double transactionValue) {
        this.transactionValue = transactionValue;
    }

    public Double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(Double newBalance) {
        this.newBalance = newBalance;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public TYPE getType(){
        return type;
    }

    public void setType(TYPE type){
        this.type = type;
    }

    public CHANNEL getChannel(){
        return channel;
    }

    public void setChannel(CHANNEL channel){
        this.channel = channel;
    }

    public Double getTax(){
        return tax;
    }

    public void setTax(Double tax){
        this.tax = tax;
    }

    public String getAccountId(){
        return accountId;
    }

    public void setAccountId(String accountId){
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "TransactionModel{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", channel=" + channel +
                ", tax=" + tax +
                ", accountId='" + accountId + '\'' +
                ", transactionValue=" + transactionValue +
                ", newBalance=" + newBalance +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
