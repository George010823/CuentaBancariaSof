package com.sofka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class InterestRateSettings {
    private String encodedKey;
    private Integer interestRate;
    private String interestChargeFrequency;
    private Integer interestChargeFrequencyCount;
    private String interestRateTerms;
    private String interestRateSource;

}
