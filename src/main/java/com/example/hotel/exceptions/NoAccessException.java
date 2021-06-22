package com.example.hotel.exceptions;

public class NoAccessException extends RuntimeException {

    public NoAccessException(String message) {
        super(message);
    }
}
