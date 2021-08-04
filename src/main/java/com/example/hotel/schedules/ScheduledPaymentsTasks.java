package com.example.hotel.schedules;

import com.example.hotel.command.reservations.CheckPaymentsCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduledPaymentsTasks {

    private final CheckPaymentsCommand checkPaymentsCommand;

    @Scheduled(cron = "0 * * * * *")
    public void CheckPayments() {
        checkPaymentsCommand.execute(null);
    }
}
