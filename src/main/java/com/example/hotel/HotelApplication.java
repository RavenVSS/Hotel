package com.example.hotel;

import com.example.hotel.room.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class HotelApplication {

	public static void main(String[] args) {
		//ApplicationContext context = SpringApplication.run(HotelApplication.class, args);

		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(RoomConfig.class);

		RoomService roomService = context.getBean("roomsService", RoomsService.class);

		Room room = roomService.create(0, "", 1, 1, TvStatus.ABSENT,
				BalconyStatus.ABSENT, FridgeStatus.ABSENT, AvailableStatus.AVAILABLE);

		System.out.println(room.getString());
	}

}
