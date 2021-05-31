package com.example.hotel.model.guests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    // TODO add user fields
    private Integer userId;
    private Integer profileId;
    private String address;
    private Integer passport;
    private Date passportDate;
    private String passportRegion;
    private Date birthdayDate;
    private String townName;
}
