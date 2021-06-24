package com.example.hotel.controller.guests.dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuestCreateDto {
    private String login;
    private String password;
    private String email;
    private String phone;
    private String firstName;
    private String secondName;
    private String middleName;
    private String address;
    private Integer passport;
    private Date passportDate;
    private String passportRegion;
    private Date birthdayDate;
    private String townName;
}
