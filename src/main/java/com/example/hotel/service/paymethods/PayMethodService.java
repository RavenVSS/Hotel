package com.example.hotel.service.paymethods;

import com.example.hotel.model.paymethods.PayMethod;

import java.util.List;

public interface PayMethodService {

    List<PayMethod> findAll();
}
