package com.sofka.api.dto.generarRetiro;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
@Data
public class TransactionDetailsDTO {
    private String transactionChannelId;
}
