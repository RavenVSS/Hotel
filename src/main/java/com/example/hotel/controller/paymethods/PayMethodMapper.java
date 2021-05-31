package com.example.hotel.controller.paymethods;

import com.example.hotel.controller.paymethods.dto.out.PayMethodDto;
import com.example.hotel.model.paymethods.PayMethod;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PayMethodMapper {

    List<PayMethodDto> toList(List<PayMethod> payMethodList);
}
