package com.example.hotel.command.reservations;

import com.example.hotel.command.core.Command;
import com.example.hotel.model.reservations.ReservationCreateArg;
import com.example.hotel.service.authentication.AuthenticationService;
import com.example.hotel.service.receipt.ReceiptService;
import com.example.hotel.service.reservations.ReservationService;
import org.springframework.context.ApplicationContext;

public class CreateReservationCommand implements Command {

    private final AuthenticationService authService;
    private final ReceiptService receiptService;
    private final ReservationService reservationService;
    private ReservationCreateArg reservationCreateArg;

    public CreateReservationCommand(ReservationCreateArg reservationCreateArg, ApplicationContext applicationContext) {
        this.reservationCreateArg = reservationCreateArg;
        authService = applicationContext.getBean(AuthenticationService.class);
        receiptService = applicationContext.getBean(ReceiptService.class);
        reservationService = applicationContext.getBean(ReservationService.class);
    }

    @Override
    public void execute() {
        reservationCreateArg.setWorkerId(authService.getCurrentUserId());
        reservationCreateArg.setReceipt(receiptService.getReceipt(reservationCreateArg.getGuestId(),
                reservationCreateArg.getRoomId()));
        reservationService.create(reservationCreateArg);
    }

    @Override
    public void undo() {
        //TODO add delete reservation
    }
}
