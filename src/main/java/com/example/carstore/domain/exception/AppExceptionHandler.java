package com.example.carstore.domain.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyTakenException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyTakenException(AlreadyTakenException ex){
        ErrorResponse response = new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorResponse> handleNotEnoughMoneyException(NotEnoughMoneyException ex){
        ErrorResponse response = new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
