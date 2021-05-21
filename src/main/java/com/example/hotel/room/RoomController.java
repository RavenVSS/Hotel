package com.example.hotel.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @PutMapping("/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addNewRoom (
            @RequestParam("pictureName") String pictureName,
            @RequestParam("storey") Integer storey,
            @RequestParam("bedCount") Integer bedCount,
            @RequestParam("price") Integer price,
            @RequestParam("tvStatus") AvailableStatus tvStatus,
            @RequestParam("balconyStatus") AvailableStatus balconyStatus,
            @RequestParam("fridgeStatus") AvailableStatus fridgeStatus,
            @RequestParam("availableStatus") AvailableStatus availableStatus
    ) {
        roomService.create(new Room.BuilderRoom()
                .pictureName(pictureName)
                .storey(storey)
                .bedCount(bedCount)
                .price(price)
                .tvStatus(tvStatus)
                .balconyStatus(balconyStatus)
                .fridgeStatus(fridgeStatus)
                .availableStatus(availableStatus)
                .build());
    }

    @PostMapping("/update")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateRoom (
            @RequestParam("id") Integer id,
            @RequestParam("pictureName") String pictureName,
            @RequestParam("storey") Integer storey,
            @RequestParam("bedCount") Integer bedCount,
            @RequestParam("price") Integer price,
            @RequestParam("tvStatus") AvailableStatus tvStatus,
            @RequestParam("balconyStatus") AvailableStatus balconyStatus,
            @RequestParam("fridgeStatus") AvailableStatus fridgeStatus,
            @RequestParam("availableStatus") AvailableStatus availableStatus
    ) {
        Room room = new Room.BuilderRoom()
                .pictureName(pictureName)
                .storey(storey)
                .bedCount(bedCount)
                .price(price)
                .tvStatus(tvStatus)
                .balconyStatus(balconyStatus)
                .fridgeStatus(fridgeStatus)
                .availableStatus(availableStatus)
                .build();
        room.setId(id);
        roomService.create(room);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteRoom(@RequestParam("id") Integer id) {
        roomService.delete(id);
    }

    @GetMapping("/all")
    public Iterable<Room> getAllRooms() {
        return roomService.findAll();
    }

    @GetMapping("/id/{id}")
    public Room getAtRoom(@PathVariable Integer id) {
        Room room = roomService.findAt(id);
        if (room == null) {
            throw new ResponseStatusException(
                    HttpStatus.NO_CONTENT);
        }
        return room;
    }
}
