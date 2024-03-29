package com.sofka.model;

public class AffectedAmounts {
    private Integer fundsAmount;
    private Integer interestAmount;
    private Integer feesAmount;
    private Integer overdraftAmount;
    private Integer overdraftFeesAmount;
    private Integer overdraftInterestAmount;
    private Integer technicalOverdraftAmount;
    private Integer technicalOverdraftInterestAmount;
    private Integer fractionAmount;

    public AffectedAmounts() {
    }

    public AffectedAmounts(Integer fundsAmount, Integer interestAmount, Integer feesAmount, Integer overdraftAmount, Integer overdraftFeesAmount, Integer overdraftInterestAmount, Integer technicalOverdraftAmount, Integer technicalOverdraftInterestAmount, Integer fractionAmount) {
        this.fundsAmount = fundsAmount;
        this.interestAmount = interestAmount;
        this.feesAmount = feesAmount;
        this.overdraftAmount = overdraftAmount;
        this.overdraftFeesAmount = overdraftFeesAmount;
        this.overdraftInterestAmount = overdraftInterestAmount;
        this.technicalOverdraftAmount = technicalOverdraftAmount;
        this.technicalOverdraftInterestAmount = technicalOverdraftInterestAmount;
        this.fractionAmount = fractionAmount;
    }

    public Integer getFundsAmount() {
        return fundsAmount;
    }

    public void setFundsAmount(Integer fundsAmount) {
        this.fundsAmount = fundsAmount;
    }

    public Integer getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(Integer interestAmount) {
        this.interestAmount = interestAmount;
    }

    public Integer getFeesAmount() {
        return feesAmount;
    }

    public void setFeesAmount(Integer feesAmount) {
        this.feesAmount = feesAmount;
    }

    public Integer getOverdraftAmount() {
        return overdraftAmount;
    }

    public void setOverdraftAmount(Integer overdraftAmount) {
        this.overdraftAmount = overdraftAmount;
    }

    public Integer getOverdraftFeesAmount() {
        return overdraftFeesAmount;
    }

    public void setOverdraftFeesAmount(Integer overdraftFeesAmount) {
        this.overdraftFeesAmount = overdraftFeesAmount;
    }

    public Integer getOverdraftInterestAmount() {
        return overdraftInterestAmount;
    }

    public void setOverdraftInterestAmount(Integer overdraftInterestAmount) {
        this.overdraftInterestAmount = overdraftInterestAmount;
    }

    public Integer getTechnicalOverdraftAmount() {
        return technicalOverdraftAmount;
    }

    public void setTechnicalOverdraftAmount(Integer technicalOverdraftAmount) {
        this.technicalOverdraftAmount = technicalOverdraftAmount;
    }

    public Integer getTechnicalOverdraftInterestAmount() {
        return technicalOverdraftInterestAmount;
    }

    public void setTechnicalOverdraftInterestAmount(Integer technicalOverdraftInterestAmount) {
        this.technicalOverdraftInterestAmount = technicalOverdraftInterestAmount;
    }

    public Integer getFractionAmount() {
        return fractionAmount;
    }

    public void setFractionAmount(Integer fractionAmount) {
        this.fractionAmount = fractionAmount;
    }

    @Override
    public String toString() {
        return "AffectedAmounts{" +
                "fundsAmount=" + fundsAmount +
                ", interestAmount=" + interestAmount +
                ", feesAmount=" + feesAmount +
                ", overdraftAmount=" + overdraftAmount +
                ", overdraftFeesAmount=" + overdraftFeesAmount +
                ", overdraftInterestAmount=" + overdraftInterestAmount +
                ", technicalOverdraftAmount=" + technicalOverdraftAmount +
                ", technicalOverdraftInterestAmount=" + technicalOverdraftInterestAmount +
                ", fractionAmount=" + fractionAmount +
                '}';
    }
}
