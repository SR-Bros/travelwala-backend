package com.ict.group06.travelwala.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiErrorHandler {
    @ExceptionHandler(WalaException.class)
    public ResponseEntity<WalaErrorResponse> handleApiException(WalaException exception) {
        return ResponseEntity.status(exception.getCode()).body(exception.getErrorResponse());
    }
}
