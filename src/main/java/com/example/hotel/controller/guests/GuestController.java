package com.example.hotel.controller.guests;

import com.example.hotel.controller.guests.dto.in.GuestCreateDto;
import com.example.hotel.controller.guests.dto.out.GuestDto;
import com.example.hotel.service.guests.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("guests")
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;
    private final GuestMapper guestMapper;

//    @PostMapping("create")
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public void addNewGuest(@RequestBody GuestCreateDto guestCreateDto) {
//        guestService.create(guestMapper.fromDto(guestCreateDto));
//    }
//
//    @GetMapping("list")
//    public List<GuestDto> getAllGuests(){
//        return null;
//    }
}
