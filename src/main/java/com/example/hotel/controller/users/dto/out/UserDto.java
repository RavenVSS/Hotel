package com.example.hotel.controller.users.dto.out;

import com.example.hotel.model.users.UserTypes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User")
public class UserDto {
    private Integer userId;
    private String login;
    private String email;
    private String phone;
    @ApiModelProperty(value = "Дата регистрации")
    private Date regDate;
    @ApiModelProperty(value = "Роль пользователя")
    private UserTypes type;
    private String firstName;
    private String secondName;
    private String middleName;
}
