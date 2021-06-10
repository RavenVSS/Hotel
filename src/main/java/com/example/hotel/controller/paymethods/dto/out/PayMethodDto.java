package com.example.hotel.controller.paymethods.dto.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "PayMethod")
public class PayMethodDto {
    private Integer id;
    private String methodName;
}
