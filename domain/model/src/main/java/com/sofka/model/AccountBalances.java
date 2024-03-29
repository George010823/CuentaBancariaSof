package com.sofka.model;

public class AccountBalances {
    private Integer totalBalance;

    public AccountBalances() {
    }

    public AccountBalances(Integer totalBalance) {
        this.totalBalance = totalBalance;
    }

    public Integer getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Integer totalBalance) {
        this.totalBalance = totalBalance;
    }

    @Override
    public String toString() {
        return "AccountBalances{" +
                "totalBalance=" + totalBalance +
                '}';
    }
}
