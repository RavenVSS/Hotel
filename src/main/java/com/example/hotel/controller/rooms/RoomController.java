package com.example.hotel.controller.rooms;

import com.example.hotel.controller.rooms.dto.in.RoomCreateDto;
import com.example.hotel.controller.rooms.dto.out.RoomDto;
import com.example.hotel.model.rooms.Room;
import com.example.hotel.model.rooms.RoomCreateArg;
import com.example.hotel.service.rooms.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "rooms", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Rooms", description = "Операции с комнатами")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    private final RoomMapper roomMapper;

    @PostMapping("create")
    @ApiOperation(value = "Создать новую комнату", nickname = "New room")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addNewRoom(@RequestBody RoomCreateDto roomCreateDto) {
        RoomCreateArg roomCreateArg = roomMapper.fromDto(roomCreateDto);
        roomService.create(roomCreateArg);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Получить комнату по ID", nickname = "Get at room")
    public RoomDto getAtRoom(@PathVariable Integer id) {
        Room room = roomService.findAt(id);
        RoomDto roomDto = roomMapper.toDto(room);
        return roomDto;
    }

    @PostMapping("{id}/update")
    @ApiOperation(value = "Обновить комнату по ID", nickname = "Update room")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateRoom(
            @PathVariable("id") Integer roomId,
            @RequestBody RoomCreateDto roomCreateDto) {
        RoomCreateArg roomCreateArg = roomMapper.fromDto(roomCreateDto);
        roomService.update(roomCreateArg, roomId);
    }

    @PostMapping("{id}/delete")
    @ApiOperation(value = "Удалить комнату по ID", nickname = "Delete room")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteRoom(@PathVariable("id") Integer id) {
        roomService.delete(id);
    }

    @GetMapping("list")
    @ApiOperation(value = "Получить все комнаты", nickname = "Get all rooms")
    public List<RoomDto> getAllRooms() {
        List<Room> rooms = roomService.findAll();
        return roomMapper.toList(rooms);
    }

    @GetMapping("free")
    @ApiOperation(value = "Получить свободные комнаты по датам приезда и отъезда", nickname = "Get free rooms")
    public List<RoomDto> getFreeRooms(@RequestParam("startDate")
                                      @DateTimeFormat(pattern="yyyy-MM-dd") Date start,
                                      @RequestParam("endDate")
                                      @DateTimeFormat(pattern="yyyy-MM-dd") Date end) {
        List<Room> rooms = roomService.findFreeRooms(start, end);
        return roomMapper.toList(rooms);
    }
}
