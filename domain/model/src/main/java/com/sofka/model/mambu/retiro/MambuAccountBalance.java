package com.sofka.model.mambu.retiro;

import lombok.Builder;

@Builder(toBuilder = true)
public class MambuAccountBalance {
    private Double totalBalance;

    public MambuAccountBalance(){

    }

    public MambuAccountBalance(Double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public Double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Double totalBalance) {
        this.totalBalance = totalBalance;
    }

    @Override
    public String toString() {
        return "AccountBalance{" +
                "totalBalance=" + totalBalance +
                '}';
    }
}
