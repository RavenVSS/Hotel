package com.example.hotel.service.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public Integer getCurrentUserId() {
        // TODO add get UserId
        return 2;
    }
}
