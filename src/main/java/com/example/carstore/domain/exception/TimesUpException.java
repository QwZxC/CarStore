package com.example.carstore.domain.exception;

public class TimesUpException extends RuntimeException {

    public TimesUpException() {
        super("The time is up");
    }
}
