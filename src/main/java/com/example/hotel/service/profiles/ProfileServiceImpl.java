package com.example.hotel.service.profiles;

import com.example.hotel.exceptions.ProfileNotFoundException;
import com.example.hotel.model.profiles.Profile;
import com.example.hotel.model.profiles.ProfileCreateArg;
import com.example.hotel.repository.profiles.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    @Transactional
    public void create(ProfileCreateArg profileCreateArg) {
        profileRepository.save(Profile.builder()
            .address(profileCreateArg.getAddress())
            .userId(profileCreateArg.getUserId())
            .birthdayDate(profileCreateArg.getBirthdayDate())
            .passport(profileCreateArg.getPassport())
            .passportDate(profileCreateArg.getPassportDate())
            .passportRegion(profileCreateArg.getPassportRegion())
            .townName(profileCreateArg.getTownName())
            .build());
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException());
        profileRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(ProfileCreateArg profileCreateArg, Integer id) {
        profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException());
        Profile profile = Profile.builder()
                .address(profileCreateArg.getAddress())
                .userId(profileCreateArg.getUserId())
                .birthdayDate(profileCreateArg.getBirthdayDate())
                .passport(profileCreateArg.getPassport())
                .passportDate(profileCreateArg.getPassportDate())
                .passportRegion(profileCreateArg.getPassportRegion())
                .townName(profileCreateArg.getTownName())
                .build();
        profile.setId(id);
        profileRepository.save(profile);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Profile> findAll() {
        List<Profile> profileList = profileRepository.findAll();
        if (profileList.isEmpty()) throw new ProfileNotFoundException();
        return profileList;
    }

    @Override
    @Transactional(readOnly = true)
    public Profile findAt(Integer id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException());
    }

    @Override
    @Transactional(readOnly = true)
    public Profile findByUserId(Integer userId) {
        Profile profile = profileRepository.findByUserId(userId);
        if (profile == null) throw new ProfileNotFoundException();
        return profile;
    }
}
