package com.example.hotel.service.guests;

import com.example.hotel.model.guests.GuestCreateArg;
import com.example.hotel.model.profiles.ProfileCreateArg;
import com.example.hotel.model.users.User;
import com.example.hotel.model.users.UserCreateArg;
import com.example.hotel.service.profiles.ProfileService;
import com.example.hotel.service.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {

    private final ProfileService profileService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void create(GuestCreateArg arg) {
        UserCreateArg userCreateArg = UserCreateArg.builder()
                .login(arg.getLogin())
                .password(passwordEncoder.encode(arg.getPassword()))
                .email(arg.getEmail())
                .phone(arg.getPhone())
                .firstName(arg.getFirstName())
                .secondName(arg.getSecondName())
                .middleName(arg.getMiddleName())
                .build();
        User user = userService.create(userCreateArg);

        ProfileCreateArg profileCreateArg = ProfileCreateArg.builder()
                .townName(arg.getTownName())
                .passportRegion(arg.getPassportRegion())
                .passportDate(arg.getPassportDate())
                .passport(arg.getPassport())
                .address(arg.getAddress())
                .birthdayDate(arg.getBirthdayDate())
                .userId(user.getId())
                .build();

        profileService.create(profileCreateArg);
    }
}
