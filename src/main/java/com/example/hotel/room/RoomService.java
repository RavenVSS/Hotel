package com.example.hotel.room;

import java.util.Date;
import java.util.List;

public interface RoomService {

    void create(RoomCreateArg arg);

    void update(RoomCreateArg arg, int roomId);

    void delete(Integer id);

    Iterable<Room> findAll();

    Room findAt(Integer id);

    List<Room> findFreeRooms(Date start, Date end);
}
