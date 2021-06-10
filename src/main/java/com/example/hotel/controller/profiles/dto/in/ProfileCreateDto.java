package com.example.hotel.controller.profiles.dto.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ProfileCreate")
public class ProfileCreateDto {
    private Integer userId;
    @ApiModelProperty(value = "Где зарегистирован (из паспорта)")
    private String address;
    @ApiModelProperty(value = "Серия и номер паспорта")
    private Integer passport;
    @ApiModelProperty(value = "Дата выдачи паспорта")
    private Date passportDate;
    @ApiModelProperty(value = "Где выдан паспорт")
    private String passportRegion;
    @ApiModelProperty(value = "Дата рождения")
    private Date birthdayDate;
    @ApiModelProperty(value = "Откуда прибыл гость")
    private String townName;
}
