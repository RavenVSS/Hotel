package com.example.hotel.room;

import java.util.Optional;

public class RoomsService implements RoomService {

    private final RoomRepository roomRepository;

    public RoomsService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void create(Room room) {
        roomRepository.save(room);
    }

    public Iterable<Room> findAll() {
        return roomRepository.findAll();
    }

    public Room findAt(Integer id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        return roomOptional.get();
    }
}
