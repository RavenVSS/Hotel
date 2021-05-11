package com.example.hotel.room;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RoomController {

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
}
