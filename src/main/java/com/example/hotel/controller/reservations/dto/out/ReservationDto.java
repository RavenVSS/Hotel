package com.example.hotel.controller.reservations.dto.out;

import com.example.hotel.model.reservations.ActualStatus;
import com.example.hotel.model.reservations.PayStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Reservation")
public class ReservationDto {
    private Integer reservationId;
    @ApiModelProperty(value = "UserID гостя")
    private Integer guestId;
    @ApiModelProperty(value = "UserID работника")
    private Integer workerId;
    private Integer roomId;
    @ApiModelProperty(value = "Дата прибытия")
    private Date beginDate;
    @ApiModelProperty(value = "Дата выезда")
    private Date endDate;
    @ApiModelProperty(value = "Бронирование актуально (не отменено)")
    private ActualStatus actualStatus;
    @ApiModelProperty(value = "ID метода оплаты")
    private Integer paymentMethodId;
    @ApiModelProperty(value = "Статус оплаты")
    private PayStatus payStatus;
    @ApiModelProperty(value = "Квитанция")
    private Integer receipt;
    @ApiModelProperty(value = "Итоовая цена")
    private Integer money;
    @ApiModelProperty(value = "Комментарий гостя")
    private String comment;
}
