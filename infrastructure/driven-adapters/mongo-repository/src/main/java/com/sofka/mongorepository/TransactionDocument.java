package com.sofka.mongorepository;
import com.sofka.model.enums.CHANNEL;
import com.sofka.model.enums.TYPE;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "transactions")
public class TransactionDocument {
    @Id
    private String id;

    private TYPE type;

    private CHANNEL channel;
    private Double newBalance;

    private Double tax;
    private String accountId;

    private Double transactionValue;

    private AccountDocument accountRepository;

    private String mambuAccountId;


    private String createdAt;

    private String mambuParentAccountKey;

    public TransactionDocument() {
    }


    public TransactionDocument(String id, TYPE type, CHANNEL channel, Double tax, String accountId, Double newBalance, String createdAt, Double transactionValue, String mambuAccountId, String mambuParentAccountKey) {
        this.id = id;
        this.type = type;
        this.channel = channel;
        this.tax = tax;
        this.accountId = accountId;
        this.newBalance = newBalance;
        this.createdAt = createdAt;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public AccountDocument getAccountRepository() {
        return accountRepository;
    }

    public void setAccountRepository(AccountDocument accountRepository) {
        this.accountRepository = accountRepository;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
