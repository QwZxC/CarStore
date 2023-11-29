package com.example.carstore.domain.exception;

public class AlreadySellingException extends RuntimeException {

    public AlreadySellingException(String message) {
        super(message);
    }
}
