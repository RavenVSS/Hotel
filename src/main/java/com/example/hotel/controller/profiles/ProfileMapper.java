package com.example.hotel.controller.profiles;

import com.example.hotel.controller.profiles.dto.in.ProfileCreateDto;
import com.example.hotel.controller.profiles.dto.out.ProfileDto;
import com.example.hotel.model.profiles.Profile;
import com.example.hotel.model.profiles.ProfileCreateArg;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    @Mapping(source = "id", target = "profileId")
    ProfileDto toDto(Profile profile);

    @Mapping(source = "id", target = "profileId")
    List<ProfileDto> toList(List<Profile> profileList);

    ProfileCreateArg fromDto(ProfileCreateDto profileCreateDto);
}
