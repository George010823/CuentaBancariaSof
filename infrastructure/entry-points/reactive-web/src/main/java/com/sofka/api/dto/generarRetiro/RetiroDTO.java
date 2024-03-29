package com.sofka.api.dto.generarRetiro;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetiroDTO {
    @NotNull(message = "no puede estar vacio")
    @Pattern(regexp = "^[0-9]+$", message = "debe ser tipo numerico")
    private String amount;

    @Valid
    @NotNull(message = "no puede estar vacio")
    @JsonProperty("transactionDetails")
    private TransactionDetailsDTO transactionDetails;

    @NotEmpty(message = "no puede estar vacio")
    private String notes;

    @NotEmpty(message = "no puede estar vacio")
    @Pattern(regexp = "^[0-9]+$", message = "debe ser tipo numerico")
    private String paymentOrderId;

    @NotEmpty(message = "no puede estar vacio")
    private String externalId;
}
