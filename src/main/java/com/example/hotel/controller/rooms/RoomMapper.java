package com.example.hotel.controller.rooms;

import com.example.hotel.controller.rooms.dto.in.RoomCreateDto;
import com.example.hotel.controller.rooms.dto.out.RoomDto;
import com.example.hotel.model.rooms.Room;
import com.example.hotel.model.rooms.RoomCreateArg;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
interface RoomMapper {
    @Mapping(source = "id", target = "roomId")
    RoomDto toDto(Room room);

    @Mapping(source = "id", target = "roomId")
    List<RoomDto> toList(List<Room> rooms);

    RoomCreateArg fromDto(RoomCreateDto dto);
}
