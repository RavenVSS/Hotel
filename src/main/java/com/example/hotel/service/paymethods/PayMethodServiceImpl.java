package com.example.hotel.service.paymethods;

import com.example.hotel.exceptions.EntityNotFoundException;
import com.example.hotel.model.paymethods.PayMethod;
import com.example.hotel.repository.paymethods.PayMethodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PayMethodServiceImpl implements PayMethodService {

    private final PayMethodRepository payMethodRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PayMethod> findAll() {
        List<PayMethod> payMethodList = payMethodRepository.findAll();
        if(payMethodList.isEmpty()) throw new EntityNotFoundException("Pay Method not found");
        return payMethodList;
    }
}
