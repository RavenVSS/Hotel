package com.example.hotel.repository.profiles;

import com.example.hotel.model.profiles.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    Profile findByUserId(Integer userId);
}
