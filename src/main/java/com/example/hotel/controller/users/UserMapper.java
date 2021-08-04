package com.example.hotel.controller.users;

import com.example.hotel.controller.users.dto.in.UserCreateDto;
import com.example.hotel.controller.users.dto.out.UserDto;
import com.example.hotel.model.users.User;
import com.example.hotel.model.users.UserCreateArg;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    UserDto toDto(User user);

    @Mapping(source = "id", target = "userId")
    List<UserDto> toList(List<User> users);

    UserCreateArg fromDto(UserCreateDto dto);
}
