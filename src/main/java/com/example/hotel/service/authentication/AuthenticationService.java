package com.example.hotel.service.authentication;

import com.example.hotel.model.users.User;

public interface AuthenticationService {

    Integer getCurrentUserId();

    User getCurrentUser();
}
