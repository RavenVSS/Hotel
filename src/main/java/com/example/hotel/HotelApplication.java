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

		Room.BuilderRoom builderRoom = new Room.BuilderRoom()
				.type(0)
				.pictureName("name")
				.storey(1)
				.bedCount(1)
				.tvStatus(AvailableStatus.AVAILABLE)
				.balconyStatus(AvailableStatus.AVAILABLE)
				.fridgeStatus(AvailableStatus.AVAILABLE)
				.availableStatus(AvailableStatus.AVAILABLE);

		Room room = roomService.create(builderRoom);

		System.out.println(room.getString());
	}

}
