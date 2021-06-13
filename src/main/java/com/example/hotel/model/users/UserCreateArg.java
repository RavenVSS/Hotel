package com.example.hotel.model.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateArg {
    private String login;
    private String password;
    private String email;
    private String phone;
    private String firstName;
    private String secondName;
    private String middleName;
}
