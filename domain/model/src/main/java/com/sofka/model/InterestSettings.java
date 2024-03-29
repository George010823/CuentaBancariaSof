package com.sofka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class InterestSettings {
    private InterestRateSettings interestRateSettings;
    private InterestPaymentSettings interestPaymentSettings;
    private String interestRate;
}
