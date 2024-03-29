package com.sofka.model;

import lombok.Builder;

@Builder(toBuilder = true)
public class TransactionDetails {
    private String transactionChannelId;

    public TransactionDetails() {
    }

    public TransactionDetails( String transactionChannelId) {
        this.transactionChannelId = transactionChannelId;
    }
    public String getTransactionChannelId() {
        return transactionChannelId;
    }

    public void setTransactionChannelId(String transactionChannelId) {
        this.transactionChannelId = transactionChannelId;
    }

    @Override
    public String toString() {
        return "TransactionDetails{" +
                ", transactionChannelId='" + transactionChannelId + '\'' +
                '}';
    }
}
