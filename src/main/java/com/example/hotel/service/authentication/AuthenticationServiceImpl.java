package com.example.hotel.service.authentication;

import com.example.hotel.model.users.User;
import com.example.hotel.service.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;

    @Override
    public Integer getCurrentUserId() {
        String login =
                SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.findByLogin(login).getId();
    }

    @Override
    public User getCurrentUser() {
        String login =
                SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.findByLogin(login);
    }
}
