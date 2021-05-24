package com.example.hotel.room;

import com.example.hotel.room.dto.RoomCreateDto;
import com.example.hotel.room.dto.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "rooms", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping("create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addNewRoom (@RequestBody RoomCreateDto roomCreateDto) {
        RoomCreateArg roomCreateArg = convertToRoomArg(roomCreateDto);
        roomService.create(roomCreateArg);
    }

    @GetMapping("{id}")
    public RoomDto getAtRoom(@PathVariable Integer id) {
        Room room = roomService.findAt(id);
        if (room == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND);
        }
        RoomDto roomDto = convertToDto(room);
        return roomDto;
    }

    @PostMapping("{id}/update")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateRoom(
            @PathVariable("id") Integer roomId,
            @RequestBody RoomCreateDto roomCreateDto) {
        RoomCreateArg roomCreateArg = convertToRoomArg(roomCreateDto);
        roomService.update(roomCreateArg, roomId);
    }

    @PostMapping("{id}/delete")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteRoom(@PathVariable("id") Integer id) {
        // TODO response status 404
        roomService.delete(id);
    }

    @GetMapping("list")
    public List<RoomDto> getAllRooms() {
        Iterable<Room> rooms = roomService.findAll();
        List<RoomDto> roomDtoList = new ArrayList<>();
        for (Room room : rooms) {
            roomDtoList.add(convertToDto(room));
        }
        return roomDtoList;
    }

    @GetMapping("free")
    public List<RoomDto> getFreeRooms(@RequestParam("startDate") String start,
                                      @RequestParam("endDate") String end) {
        List<Room> rooms = roomService.findFreeRooms(start, end);
        List<RoomDto> roomDtoList = new ArrayList<>();
        for (Room room : rooms) {
            roomDtoList.add(convertToDto(room));
        }
        return roomDtoList;
    }

    private RoomDto convertToDto(Room room) {
        RoomDto roomDto = new RoomDto.BuilderRoomDto()
                .roomId(room.getId())
                .pictureName(room.getPictureName())
                .storey(room.getStorey())
                .bedCount(room.getBedCount())
                .price(room.getPrice())
                .tvStatus(room.getTvStatus())
                .balconyStatus(room.getBalconyStatus())
                .fridgeStatus(room.getFridgeStatus())
                .availableStatus(room.getAvailableStatus())
                .build();
        return roomDto;
    }

    private RoomCreateArg convertToRoomArg(RoomCreateDto roomCreateDto) {
        RoomCreateArg roomCreateArg = new RoomCreateArg.BuilderRoomCreateArg()
                .pictureName(roomCreateDto.getPictureName())
                .storey(roomCreateDto.getStorey())
                .bedCount(roomCreateDto.getBedCount())
                .price(roomCreateDto.getPrice())
                .tvStatus(roomCreateDto.getTvStatus())
                .balconyStatus(roomCreateDto.getBalconyStatus())
                .fridgeStatus(roomCreateDto.getFridgeStatus())
                .availableStatus(roomCreateDto.getAvailableStatus())
                .build();
        return roomCreateArg;
    }
}
