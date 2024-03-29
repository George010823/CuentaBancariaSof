package com.sofka.model.enums;

public enum CHANNEL {
    PHYSICAL_LOCATION,
    ATM,
    ANOTHER_ACCOUNT,
    PHYSICAL_STORE,
    WEB;

    public String toString() {
        return name();
    }
}
