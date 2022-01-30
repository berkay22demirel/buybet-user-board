package com.berkay22demirel.buybetuserboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BuybetNotFoundException extends BuybetBusinessException {

    public BuybetNotFoundException(String message) {
        super(message);
    }

    public BuybetNotFoundException(String message, Object[] arguments) {
        super(message, arguments);
    }
}
