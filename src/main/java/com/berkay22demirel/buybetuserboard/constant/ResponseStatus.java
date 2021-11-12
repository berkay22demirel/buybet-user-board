package com.berkay22demirel.buybetuserboard.constant;

public enum ResponseStatus {

    SUCCESS("success"),
    FAILURE("failure");

    private final String value;

    private ResponseStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
