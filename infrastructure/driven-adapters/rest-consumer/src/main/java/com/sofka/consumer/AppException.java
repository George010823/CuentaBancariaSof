package com.sofka.consumer;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AppException extends ResponseStatusException {
    private final HttpStatus statusCode;
    private final String message;

    public AppException(HttpStatus status, String reason) {
        super(status, reason);
        statusCode = status;
        message = reason;
    }
}
