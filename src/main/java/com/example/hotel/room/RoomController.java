package com.example.hotel.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/room/add")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public void addNewRoom () {
        roomService.create(new Room.BuilderRoom()
                .pictureName("pictureName")
                .storey(1)
                .bedCount(1)
                .price(1000)
                .tvStatus(AvailableStatus.AVAILABLE)
                .balconyStatus(AvailableStatus.AVAILABLE)
                .fridgeStatus(AvailableStatus.AVAILABLE)
                .availableStatus(AvailableStatus.AVAILABLE)
                .build());
    }

    @GetMapping("/room/all")
    @ResponseBody
    public Iterable<Room> getAllRooms() {
        return roomService.findAll();
    }

    @GetMapping("/room/id/{id}")
    @ResponseBody
    public Room getAtRoom(@PathVariable int id) {
        return roomService.findAt(id);
    }
}
