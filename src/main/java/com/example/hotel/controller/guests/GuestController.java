package com.example.hotel.controller.guests;

import com.example.hotel.controller.guests.dto.in.GuestCreateDto;
import com.example.hotel.service.guests.GuestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "guests", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Guests", description = "Операции с гостями")
@RequiredArgsConstructor
public class GuestController {
    private final GuestService guestService;
    private final GuestMapper guestMapper;

    @PostMapping("create")
    @ApiOperation(value = "Зарегистировать гостя со всеми данными. Доступ: WORKER", nickname = "Register guest")
    @PreAuthorize("hasRole('WORKER')")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addNewGuest(@RequestBody GuestCreateDto guestCreateDto) {
        guestService.create(guestMapper.fromDto(guestCreateDto));
    }
}
