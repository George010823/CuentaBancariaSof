package com.sofka.consumer.generarRetiro.dto;

import com.sofka.model.AccountBalances;
import com.sofka.model.AffectedAmounts;
import com.sofka.model.Terms;
import com.sofka.model.TransactionDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ResponseRetiroDTO {
    private String encodedKey;
    private String id;
    private String externalId;
    private String paymentOrderId;
    private String creationDate;
    private String valueDate;
    private String notes;
    private String parentAccountKey;
    private String type;
    private Integer amount;
    private String currencyCode;
    private AffectedAmounts affectedAmounts;
    private AccountBalances accountBalances;
    private String userKey;
    private Terms terms;
    private TransactionDetails transactionDetails;
}
