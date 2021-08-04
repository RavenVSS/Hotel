package com.example.hotel.exceptions;

public class LoginIsNotFreeException extends RuntimeException {

    public LoginIsNotFreeException(String message) {
        super(message);
    }
}
