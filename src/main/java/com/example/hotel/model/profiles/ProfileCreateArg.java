package com.example.hotel.model.profiles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCreateArg {
    private Integer userId;
    private String address;
    private Integer passport;
    private Date passportDate;
    private String passportRegion;
    private Date birthdayDate;
    private String townName;
}