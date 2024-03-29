package com.sofka.model.mambu.retiro;

import com.sofka.model.TransactionDetails;

public class RequestRetiro {
    private double amount;
    private TransactionDetails transactionDetails;
    private MambuTrxCnlCashDepFields _trxcnlcashdepfields;
    private String notes;
    private String paymentOrderId;
    private String externalId;

    public RequestRetiro() {
    }

    public MambuTrxCnlCashDepFields get_trxcnlcashdepfields() {
        return _trxcnlcashdepfields;
    }

    public void set_trxcnlcashdepfields(MambuTrxCnlCashDepFields _trxcnlcashdepfields) {
        this._trxcnlcashdepfields = _trxcnlcashdepfields;
    }

    public RequestRetiro(double amount, TransactionDetails transactionDetails, MambuTrxCnlCashDepFields _trxcnlcashdepfields, String notes, String paymentOrderId, String externalId) {
        this.amount = amount;
        this.paymentOrderId = paymentOrderId;
        this.externalId = externalId;
        this.notes = notes;
        this.transactionDetails = transactionDetails;
        this._trxcnlcashdepfields = _trxcnlcashdepfields;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionDetails getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(TransactionDetails transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPaymentOrderId() {
        return paymentOrderId;
    }

    public void setPaymentOrderId(String paymentOrderId) {
        this.paymentOrderId = paymentOrderId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @Override
    public String toString() {
        return "RequestRetiro{" +
                "amount='" + amount + '\'' +
                ", transactionDetails=" + transactionDetails +
                ", _trxcnlcashdepfields=" + _trxcnlcashdepfields +
                ", notes='" + notes + '\'' +
                ", paymentOrderId='" + paymentOrderId + '\'' +
                ", externalId='" + externalId + '\'' +
                '}';
    }
}
