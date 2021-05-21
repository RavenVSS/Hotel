package com.example.hotel.room;

public interface RoomService {

    void create(Room room);

    void delete(Integer id);

    Iterable<Room> findAll();

    Room findAt(Integer id);

    // TODO Iterable<Rooms> findFreeRooms();
}
