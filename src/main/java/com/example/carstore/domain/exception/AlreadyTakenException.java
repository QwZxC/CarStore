package com.example.carstore.domain.exception;

public class AlreadyTakenException extends RuntimeException {
    public AlreadyTakenException(String message){
        super(message);
    }
}
