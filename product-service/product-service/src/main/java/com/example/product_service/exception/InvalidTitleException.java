package com.example.product_service.exception;

public class InvalidTitleException extends RuntimeException{
    public InvalidTitleException() {
    }

    public InvalidTitleException(String message) {
        super(message);
    }
}