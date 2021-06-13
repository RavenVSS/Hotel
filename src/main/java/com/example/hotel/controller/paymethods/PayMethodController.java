package com.example.hotel.controller.paymethods;

import com.example.hotel.controller.paymethods.dto.out.PayMethodDto;
import com.example.hotel.service.paymethods.PayMethodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("paymethods")
@Api(tags = "Pay Methods", description = "Операции с методами оплаты")
@RequiredArgsConstructor
public class PayMethodController {

    private final PayMethodService payMethodService;
    private final PayMethodMapper payMethodMapper;

    @GetMapping("list")
    @PreAuthorize("hasRole('WORKER') || hasRole('USER')")
    @ApiOperation(value = "Получить список методов оплаты", nickname = "Pay Methods")
    public List<PayMethodDto> getAllPayMethods() {
        return payMethodMapper.toList(payMethodService.findAll());
    }
}
