package com.example.hotel.service.authentication;

import com.example.hotel.config.security.UserCustom;
import com.example.hotel.model.users.User;
import com.example.hotel.model.users.UserTypes;
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
        UserCustom userCustom = (UserCustom)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userCustom.getUserId();
    }

    @Override
    public User getCurrentUser() {
        UserCustom userCustom = (UserCustom)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.findAt(userCustom.getUserId());
    }

    @Override
    public UserTypes getCurrentRole() {
        UserCustom userCustom = (UserCustom)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userCustom.getType();
    }
}
