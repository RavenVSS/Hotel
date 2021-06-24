package com.example.hotel.controller.guests;

import com.example.hotel.controller.guests.dto.in.GuestCreateDto;
import com.example.hotel.controller.guests.dto.out.GuestDto;
import com.example.hotel.model.guests.Guest;
import com.example.hotel.model.guests.GuestCreateArg;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GuestMapper {

    GuestDto toDto(Guest guest);

    List<GuestDto> toList(List<Guest> guestList);

    GuestCreateArg fromDto(GuestCreateDto GuestCreateDto);

}
