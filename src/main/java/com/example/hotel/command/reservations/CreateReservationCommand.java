package com.example.hotel.command.reservations;

import com.example.hotel.command.core.Command;
import com.example.hotel.model.reservations.ReservationCreateArg;
import com.example.hotel.service.authentication.AuthenticationService;
import com.example.hotel.service.receipt.ReceiptService;
import com.example.hotel.service.reservations.ReservationService;
import org.springframework.context.ApplicationContext;

public class CreateReservationCommand implements Command<ReservationCreateArg, Void> {

    private final AuthenticationService authService;
    private final ReceiptService receiptService;
    private final ReservationService reservationService;

    public CreateReservationCommand(ApplicationContext applicationContext) {
        authService = applicationContext.getBean(AuthenticationService.class);
        receiptService = applicationContext.getBean(ReceiptService.class);
        reservationService = applicationContext.getBean(ReservationService.class);
    }

    @Override
    public Void execute(ReservationCreateArg reservationCreateArg) {
        reservationCreateArg.setWorkerId(authService.getCurrentUserId());
        reservationCreateArg.setReceipt(receiptService.getReceipt(reservationCreateArg.getGuestId(),
                reservationCreateArg.getRoomId()));
        reservationService.create(reservationCreateArg);
        return null;
    }
}
