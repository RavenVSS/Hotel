package com.example.hotel.room;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoomConfig {

    @Bean
    public RoomsService roomsService(RoomRepository roomRepository) {
        return new RoomsService(roomRepository);
    }
}
