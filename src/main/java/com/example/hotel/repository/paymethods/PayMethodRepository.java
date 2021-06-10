package com.example.hotel.repository.paymethods;

import com.example.hotel.model.paymethods.PayMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayMethodRepository extends JpaRepository<PayMethod, Integer> {

}
