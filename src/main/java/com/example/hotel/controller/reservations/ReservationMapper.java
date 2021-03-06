package com.example.hotel.controller.reservations;

import com.example.hotel.controller.reservations.dto.in.ReservationCreateDto;
import com.example.hotel.controller.reservations.dto.out.ReservationDto;
import com.example.hotel.model.reservations.Reservation;
import com.example.hotel.model.reservations.ReservationCreateArg;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(source = "id", target = "reservationId")
    ReservationDto toDto(Reservation reservation);

    @Mapping(source = "id", target = "reservationId")
    List<ReservationDto> toList(List<Reservation> reservationList);

    ReservationCreateArg fromDto(ReservationCreateDto dto);
}
