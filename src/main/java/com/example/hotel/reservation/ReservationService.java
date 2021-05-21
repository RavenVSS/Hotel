package com.example.hotel.reservation;

import java.util.List;

public interface ReservationService {

    void create(Reservation reservation);

    void delete(Integer id);

    List<Reservation> findAll();

    Reservation findAt(Integer id);
}
