package com.example.hotel.exceptions;

public class PayMethodNotFoundException extends RuntimeException {

    public PayMethodNotFoundException() {
        super("Pay Method not found");
    }
}
