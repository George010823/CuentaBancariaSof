package com.sofka.model;

public class Terms {
    private InterestSettings interestSettings;

    public Terms() {
    }

    public Terms(InterestSettings interestSettings) {
        this.interestSettings = interestSettings;
    }

    public InterestSettings getInterestSettings() {
        return interestSettings;
    }

    public void setInterestSettings(InterestSettings interestSettings) {
        this.interestSettings = interestSettings;
    }

    @Override
    public String toString() {
        return "Terms{" +
                "interestSettings=" + interestSettings +
                '}';
    }
}
