package com.example.hotel.schedules;

import com.example.hotel.command.reservations.CheckPaymentsCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class ScheduledPaymentsTasks {

    private final ApplicationContext context;
    private final Map<Integer, Date> startPaymentsReservation = new HashMap<>();

    @Scheduled(cron = "0 * * * * *")
    public void CheckPayments() {
        if (!startPaymentsReservation.isEmpty()) {
            ArrayList<Integer> removeList = new ArrayList<Integer>();

            startPaymentsReservation.forEach((reservationId, date) -> {
                if ((new Date().getTime() - date.getTime())/60000 >= 15) {
                    new CheckPaymentsCommand(context).execute(reservationId);
                    removeList.add(reservationId);
                }
            });

            for (Integer reservationId : removeList) {
                startPaymentsReservation.remove(reservationId);
            }
        }
    }

    public void addReservationPayment(Integer reservationId) {
        startPaymentsReservation.put(reservationId, new Date());
    }
}
