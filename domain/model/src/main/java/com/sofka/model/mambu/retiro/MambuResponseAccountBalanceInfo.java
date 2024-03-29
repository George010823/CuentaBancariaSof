package com.sofka.model.mambu.retiro;

public class MambuResponseAccountBalanceInfo {
    private MambuAccountBalance balances;

    public MambuResponseAccountBalanceInfo() {

    }

    public MambuResponseAccountBalanceInfo(MambuAccountBalance balances) {
        this.balances = balances;
    }

    public MambuAccountBalance getBalances() {
        return balances;
    }

    public void setBalances(MambuAccountBalance balances) {
        this.balances = balances;
    }

    @Override
    public String toString() {
        return "ResponseAccountBalanceInfo{" +
                "balances=" + balances +
                '}';
    }
}
