package com.berkay22demirel.buybetuserboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BuybetUnexpectedException extends BuybetBusinessException {

    public BuybetUnexpectedException(String message) {
        super(message);
    }

    public BuybetUnexpectedException(String message, Object[] arguments) {
        super(message, arguments);
    }
}
