package com.example.hotel.command.reservations;

import com.example.hotel.command.core.Command;
import com.example.hotel.model.reservations.Reservation;
import com.example.hotel.service.authentication.AuthenticationService;
import com.example.hotel.service.reservations.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetReservationsCurrentUserCommand implements Command<Void, List<Reservation>> {

    private final ReservationService reservationService;
    private final AuthenticationService authService;

    @Override
    public List<Reservation> execute(Void unused) {
        return reservationService.findByGuestId(authService.getCurrentUserId());
    }
}
