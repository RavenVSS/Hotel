package com.example.hotel.room;

import java.util.Date;
import java.util.List;

public interface RoomService {

    void create(Room room);

    void update(Room room);

    void delete(Integer id);

    Iterable<Room> findAll();

    Room findAt(Integer id);

    List<Room> findFreeRooms(String start, String end);
}
