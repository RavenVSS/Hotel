package com.example.hotel.service.authentication;

import com.example.hotel.model.users.User;
import com.example.hotel.model.users.UserTypes;

public interface AuthenticationService {

    Integer getCurrentUserId();

    User getCurrentUser();

    UserTypes getCurrentRole();
}
