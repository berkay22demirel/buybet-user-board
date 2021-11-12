package com.berkay22demirel.buybetuserboard.controller;

import com.berkay22demirel.buybetuserboard.constant.ResponseStatus;
import com.berkay22demirel.buybetuserboard.controller.response.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handle(MethodArgumentNotValidException exception, Locale locale) {
        Map<String, String> validationErrors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        ValidationErrorResponse response = new ValidationErrorResponse(ResponseStatus.FAILURE.getValue());
        response.setValidationErrors(validationErrors);
        response.setErrorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        response.setErrorMessage("Validation Error");
        return ResponseEntity.badRequest().body(response);
    }

}
