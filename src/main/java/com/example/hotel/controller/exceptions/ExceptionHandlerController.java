package com.example.hotel.controller.exceptions;

import com.example.hotel.controller.exceptions.dto.ErrorDto;
import com.example.hotel.exceptions.PayMethodNotFoundException;
import com.example.hotel.exceptions.ProfileNotFoundException;
import com.example.hotel.exceptions.ReservationNotFoundException;
import com.example.hotel.exceptions.RoomNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({RoomNotFoundException.class,
            ReservationNotFoundException.class,
            ProfileNotFoundException.class,
            PayMethodNotFoundException.class})
    @ResponseBody
    public ErrorDto handleConflict(Exception ex) {
        return new ErrorDto(ex.getLocalizedMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ErrorDto handleConflict() {
        return new ErrorDto("Error query");
    }
}

