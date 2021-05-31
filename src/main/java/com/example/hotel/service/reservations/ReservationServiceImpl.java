package com.example.hotel.service.reservations;

import com.example.hotel.exceptions.ReservationNotFoundException;
import com.example.hotel.model.reservations.ActualStatus;
import com.example.hotel.model.reservations.Reservation;
import com.example.hotel.model.reservations.ReservationCreateArg;
import com.example.hotel.repository.reservations.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    @Transactional
    public void create(ReservationCreateArg reservationCreateArg) {
        // TODO add receipt
        // TODO worker from session
        reservationRepository.save(Reservation.builder()
            .roomId(reservationCreateArg.getRoomId())
            .actualStatus(ActualStatus.ACTUAL)
            .payStatus(reservationCreateArg.getPayStatus())
            .beginDate(reservationCreateArg.getBeginDate())
            .endDate(reservationCreateArg.getEndDate())
            .guestId(reservationCreateArg.getGuestId())
            .workerId(reservationCreateArg.getWorkerId())
            .money(reservationCreateArg.getMoney())
            .comment(reservationCreateArg.getComment())
            .paymentMethodId(reservationCreateArg.getPaymentMethodId())
            .build());
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException());
        reservationRepository.deleteById(id);
    }

    @Override
    public void update(ReservationCreateArg reservationCreateArg, Integer id) {
        reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException());
        // TODO add receipt
        // TODO worker from session
        Reservation reservation = Reservation.builder()
                .roomId(reservationCreateArg.getRoomId())
                .actualStatus(ActualStatus.ACTUAL)
                .payStatus(reservationCreateArg.getPayStatus())
                .beginDate(reservationCreateArg.getBeginDate())
                .endDate(reservationCreateArg.getEndDate())
                .guestId(reservationCreateArg.getGuestId())
                .workerId(reservationCreateArg.getWorkerId())
                .money(reservationCreateArg.getMoney())
                .comment(reservationCreateArg.getComment())
                .paymentMethodId(reservationCreateArg.getPaymentMethodId())
                .build();
        reservation.setId(id);
        reservationRepository.save(reservation);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservation> findAll() {
        List<Reservation> reservationList = reservationRepository.findAll();
        if (reservationList.isEmpty()) throw new ReservationNotFoundException();
        return reservationList;
    }

    @Override
    @Transactional(readOnly = true)
    public Reservation findAt(Integer id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException());
        return reservation;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservation> findByBeginDate(Date beginDate) {
        List<Reservation> reservationList = reservationRepository.findByBeginDate(beginDate);
        if (reservationList.isEmpty()) throw new ReservationNotFoundException();
        return reservationList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservation> findByName(String firstName, String secondName) {
        List<Reservation> reservationList = reservationRepository.findByName(firstName, secondName);
        if (reservationList.isEmpty()) throw new ReservationNotFoundException();
        return reservationList;
    }

}
