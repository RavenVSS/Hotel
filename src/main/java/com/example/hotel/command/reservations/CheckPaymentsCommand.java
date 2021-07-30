package com.example.hotel.command.reservations;

import com.example.hotel.command.core.Command;
import com.example.hotel.service.reservations.ReservationService;
import org.springframework.context.ApplicationContext;

public class CheckPaymentsCommand implements Command<Integer, Void> {

    private final ReservationService reservationService;

    public CheckPaymentsCommand(ApplicationContext applicationContext) {
        reservationService = applicationContext.getBean(ReservationService.class);
    }

    @Override
    public Void execute(Integer reservationId) {
        reservationService.checkPaymentById(reservationId);
        return null;
    }
}
