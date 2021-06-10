package com.example.hotel.controller.rooms.dto.in;

import com.example.hotel.model.rooms.AvailableStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "RoomCreate")
public class RoomCreateDto {
    @ApiModelProperty(value = "Имя файла с картинкой")
    private String pictureName;
    @ApiModelProperty(value = "Этаж")
    private int storey;
    @ApiModelProperty(value = "Количество кроватей")
    private int bedCount;
    @ApiModelProperty(value = "Цена за сутки")
    private int price;
    @ApiModelProperty(value = "Наличие TV")
    private AvailableStatus tvStatus;
    @ApiModelProperty(value = "Наличие балкона")
    private AvailableStatus balconyStatus;
    @ApiModelProperty(value = "Наличие холодильника")
    private AvailableStatus fridgeStatus;
    @ApiModelProperty(value = "Доступна для бронирования")
    private AvailableStatus availableStatus;
}
