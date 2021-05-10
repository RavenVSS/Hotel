package com.example.hotel.room;

public class RoomsService implements RoomService {

    public Room create(Room.BuilderRoom builderRoom) {
        return builderRoom.build();
    }
}
