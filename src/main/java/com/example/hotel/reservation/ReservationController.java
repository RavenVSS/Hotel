package com.example.hotel.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PutMapping("/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addNewReservation (
            @RequestParam("guestId") Integer guestId,
            @RequestParam("roomId") Integer roomId,
            @RequestParam("beginDate")
            @DateTimeFormat(pattern ="yyyy-mm-dd") Date beginDate,
            @RequestParam("endDate")
            @DateTimeFormat(pattern ="yyyy-mm-dd") Date endDate,
            @RequestParam("paymentMethodId") Integer paymentMethodId,
            @RequestParam("payStatus") PayStatus payStatus,
            @RequestParam("money") Integer money,
            @RequestParam("comment") String comment
    ) {
        reservationService.create(new Reservation.BuilderReservation()
                .guestId(guestId)
                .workerId(2) // TODO worker from session
                .roomId(roomId)
                .beginDate(beginDate)
                .endDate(endDate)
                .actualStatus(ActualStatus.ACTUAL)
                .paymentMethodId(paymentMethodId)
                .payStatus(payStatus)
                .receipt(000) // TODO receipt generation
                .money(money)
                .comment(comment)
                .build());
    }

    @PostMapping("/update")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateReservation (
            @RequestParam("id") Integer id,
            @RequestParam("guestId") Integer guestId,
            @RequestParam("roomId") Integer roomId,
            @RequestParam("beginDate") Date beginDate,
            @RequestParam("endDate") Date endDate,
            @RequestParam("paymentMethodId") Integer paymentMethodId,
            @RequestParam("payStatus") PayStatus payStatus,
            @RequestParam("money") Integer money,
            @RequestParam("comment") String comment
    ) {
        Reservation reservation = new Reservation.BuilderReservation()
                .guestId(guestId)
                .workerId(1) // TODO worker from session
                .roomId(roomId)
                .beginDate(beginDate)
                .endDate(endDate)
                .actualStatus(ActualStatus.ACTUAL)
                .paymentMethodId(paymentMethodId)
                .payStatus(payStatus)
                .receipt(000) // TODO receipt generation
                .money(money)
                .comment(comment)
                .build();
        reservation.setId(id);
        reservationService.create(reservation);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteReservation(@RequestParam("id") Integer id) {
        reservationService.delete(id);
    }

    @GetMapping("/all")
    public Iterable<Reservation> getAllReservations() {
        return reservationService.findAll();
    }

    @GetMapping("/id/{id}")
    public Reservation getAtReservation(@PathVariable Integer id) {
        Reservation reservation = reservationService.findAt(id);
        if (reservation == null) {
            throw new ResponseStatusException(
                    HttpStatus.NO_CONTENT);
        }
        return reservation;
    }
}
