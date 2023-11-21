package com.example.carstore.domain.exception;

public class NotEnoughMoneyException extends RuntimeException{

    public NotEnoughMoneyException(){
        super("Not enough money");
    }
}
