package com.berkay22demirel.buybetuserboard.constant;

public enum ResponseStatus implements BasicEnum<String> {

    SUCCESS("success"),
    FAILURE("failure");

    private final String value;

    private ResponseStatus(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
    
}
