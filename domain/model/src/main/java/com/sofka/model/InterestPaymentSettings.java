package com.sofka.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class InterestPaymentSettings {
    private String interestPaymentPoint;
    private List<InterestPaymentDates> interestPaymentDates;
}
