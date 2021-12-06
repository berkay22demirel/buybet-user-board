package com.berkay22demirel.buybetuserboard.exception;

public class BuybetBusinessException extends RuntimeException {

    private final Object[] arguments;

    public BuybetBusinessException(String message) {
        super(message);
        this.arguments = new Object[0];
    }

    public BuybetBusinessException(String message, Object[] arguments) {
        super(message);
        this.arguments = arguments;
    }

    public Object[] getArguments() {
        return arguments;
    }
}
