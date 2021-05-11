package com.example.hotel.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoomController {

    @Autowired
    RoomService roomService;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/room")
    public String getRoom(Model model) {
        model.addAttribute("id", -1);
        return "room/room";
    }

    @GetMapping("/room/{id}")
    public String getRoom(Model model,@PathVariable int id) {
        model.addAttribute("id", id);
        return "room/room";
    }

    @PostMapping("/room/add")
    @ResponseBody
    public String addNewRoom (@RequestParam String pictureName
            , @RequestParam int storey) {

        Room room = roomService.create(new Room.BuilderRoom()
                .type(0)
                .pictureName(pictureName)
                .storey(storey)
                .bedCount(1)
                .tvStatus(AvailableStatus.AVAILABLE)
                .balconyStatus(AvailableStatus.AVAILABLE)
                .fridgeStatus(AvailableStatus.AVAILABLE)
                .availableStatus(AvailableStatus.AVAILABLE));
        roomRepository.save(room);
        return "Saved";
    }

    @GetMapping("/room/all")
    @ResponseBody
    public Iterable<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
