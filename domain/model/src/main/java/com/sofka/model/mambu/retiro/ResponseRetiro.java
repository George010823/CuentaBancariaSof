package com.sofka.model.mambu.retiro;

import com.sofka.model.AccountBalances;
import com.sofka.model.AffectedAmounts;
import com.sofka.model.Terms;
import com.sofka.model.TransactionDetails;

public class ResponseRetiro {
    private String encodedKey;
    private String id;
    private String externalId;
    private String paymentOrderId;
    private String creationDate;
    private String notes;
    private String parentAccountKey;
    private String type;
    private Double amount;
    private String currencyCode;
    private String userKey;
    private MambuAccountBalance accountBalances;
    private TransactionDetails transactionDetails;

    public ResponseRetiro() {
    }

    public ResponseRetiro(String encodedKey, String id, String externalId, String paymentOrderId, String creationDate, String notes, String parentAccountKey, String type, Double amount, String currencyCode, String userKey, MambuAccountBalance accountBalances, TransactionDetails transactionDetails) {
        this.encodedKey = encodedKey;
        this.id = id;
        this.externalId = externalId;
        this.paymentOrderId = paymentOrderId;
        this.creationDate = creationDate;
        this.notes = notes;
        this.parentAccountKey = parentAccountKey;
        this.type = type;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.userKey = userKey;
        this.accountBalances = accountBalances;
        this.transactionDetails = transactionDetails;
    }

    public String getEncodedKey() {
        return encodedKey;
    }

    public void setEncodedKey(String encodedKey) {
        this.encodedKey = encodedKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getPaymentOrderId() {
        return paymentOrderId;
    }

    public void setPaymentOrderId(String paymentOrderId) {
        this.paymentOrderId = paymentOrderId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getParentAccountKey() {
        return parentAccountKey;
    }

    public void setParentAccountKey(String parentAccountKey) {
        this.parentAccountKey = parentAccountKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public MambuAccountBalance getAccountBalances() {
        return accountBalances;
    }

    public void setAccountBalances(MambuAccountBalance accountBalances) {
        this.accountBalances = accountBalances;
    }

    public TransactionDetails getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(TransactionDetails transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    @Override
    public String toString() {
        return "ResponseRetiro{" +
                "encodedKey='" + encodedKey + '\'' +
                ", id='" + id + '\'' +
                ", externalId='" + externalId + '\'' +
                ", paymentOrderId='" + paymentOrderId + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", notes='" + notes + '\'' +
                ", parentAccountKey='" + parentAccountKey + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", currencyCode='" + currencyCode + '\'' +
                ", userKey='" + userKey + '\'' +
                ", accountBalances=" + accountBalances +
                ", transactionDetails=" + transactionDetails +
                '}';
    }
}
