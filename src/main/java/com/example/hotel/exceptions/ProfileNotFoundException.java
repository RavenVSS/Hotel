package com.example.hotel.exceptions;

public class ProfileNotFoundException extends RuntimeException {

    public ProfileNotFoundException() {
        super("Profile not found");
    }
}
