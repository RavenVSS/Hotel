package com.example.hotel.service.reservations;

import com.example.hotel.model.reservations.Reservation;
import com.example.hotel.model.reservations.ReservationCreateArg;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ReservationService {

    void create(ReservationCreateArg reservationCreateArg);

    void delete(Integer id);

    void update(ReservationCreateArg reservationCreateArg, Integer id);

    List<Reservation> findAll();

    Reservation findAt(Integer id);

    List<Reservation> findByBeginDate(Date beginDate);

    List<Reservation> findByName(String firstName, String secondName);

    List<Reservation> findByGuestId(Integer guestId);

    void checkPayments();
}
