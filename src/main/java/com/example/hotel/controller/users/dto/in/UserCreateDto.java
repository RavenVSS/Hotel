package com.example.hotel.controller.users.dto.in;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "UserCreate")
public class UserCreateDto {
    private String login;
    private String password;
    private String email;
    private String phone;
    private String firstName;
    private String secondName;
    private String middleName;
}
