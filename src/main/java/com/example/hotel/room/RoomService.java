package com.example.hotel.room;

public interface RoomService {

    void create(Room room);

    Iterable<Room> findAll();

    Room findAt(Integer id);
}
