package com.example.hotel.service.guests;

import com.example.hotel.model.guests.GuestCreateArg;
import com.example.hotel.model.profiles.Profile;
import com.example.hotel.repository.profiles.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {

    private final ProfileRepository profileRepository;

    @Override
    @Transactional
    public void create(GuestCreateArg guestCreateArg) {
        //TODO user create
        Profile profile = Profile.builder()
                .townName(guestCreateArg.getTownName())
                .passportRegion(guestCreateArg.getPassportRegion())
                .passportDate(guestCreateArg.getPassportDate())
                .passport(guestCreateArg.getPassport())
                .address(guestCreateArg.getAddress())
                .birthdayDate(guestCreateArg.getBirthdayDate())
                //.userId()
                .build();

    }
}
