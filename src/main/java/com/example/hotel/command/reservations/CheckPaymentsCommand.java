package com.example.hotel.command.reservations;

import com.example.hotel.command.core.Command;
import com.example.hotel.service.reservations.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckPaymentsCommand implements Command<Void, Void> {

    private final ReservationService reservationService;

    @Override
    public Void execute(Void unused) {
        reservationService.checkPayments();
        return null;
    }
}
