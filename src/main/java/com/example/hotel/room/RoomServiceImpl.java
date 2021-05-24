package com.example.hotel.room;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void create(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void update(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void delete(Integer id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Iterable<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findAt(Integer id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        return roomOptional.orElse(null);
    }

    @Override
    public List<Room> findFreeRooms(String start, String end) {
        return roomRepository.findFreeRooms(start, end);
    }

}
