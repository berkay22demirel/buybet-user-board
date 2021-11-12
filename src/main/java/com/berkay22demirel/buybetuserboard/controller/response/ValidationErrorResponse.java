package com.berkay22demirel.buybetuserboard.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ValidationErrorResponse extends Response {

    private Map<String, String> validationErrors;

    public ValidationErrorResponse(String status) {
        super(status);
    }
}
