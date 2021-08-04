package com.example.hotel.service.email;

import com.example.hotel.model.users.User;

public interface EmailService {

    void sendConfirm(User user);

    void sendUserData(User user);
}
