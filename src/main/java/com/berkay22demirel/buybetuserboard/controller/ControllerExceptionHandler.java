package com.berkay22demirel.buybetuserboard.controller;

import com.berkay22demirel.buybetuserboard.controller.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handle(MethodArgumentNotValidException exception) {
        Map<String, String> validationErrors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(new Response("Validation Error", validationErrors));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handle(Exception exception) {
        return ResponseEntity.badRequest().body(new Response(exception.getMessage()));
    }

}
