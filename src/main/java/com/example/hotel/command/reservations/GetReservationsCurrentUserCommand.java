package com.example.hotel.command.reservations;

import com.example.hotel.command.core.Command;
import com.example.hotel.model.reservations.Reservation;
import com.example.hotel.service.authentication.AuthenticationService;
import com.example.hotel.service.reservations.ReservationService;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class GetReservationsCurrentUserCommand implements Command<Void, List<Reservation>> {

    private final ReservationService reservationService;
    private final AuthenticationService authService;

    public GetReservationsCurrentUserCommand(ApplicationContext context) {
        authService = context.getBean(AuthenticationService.class);
        reservationService = context.getBean(ReservationService.class);
    }

    @Override
    public List<Reservation> execute(Void unused) {
        return reservationService.findByGuestId(authService.getCurrentUserId());
    }
}
