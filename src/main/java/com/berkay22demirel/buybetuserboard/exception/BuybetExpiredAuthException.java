package com.berkay22demirel.buybetuserboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class BuybetExpiredAuthException extends AuthenticationException {

    private final Object[] arguments;

    public BuybetExpiredAuthException(String message) {
        super(message);
        this.arguments = new Object[0];
    }

    public BuybetExpiredAuthException(String message, Object[] arguments) {
        super(message);
        this.arguments = arguments;
    }

    public Object[] getArguments() {
        return arguments;
    }
}
