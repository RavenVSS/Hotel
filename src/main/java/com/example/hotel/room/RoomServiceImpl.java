package com.example.hotel.room;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void create(RoomCreateArg arg) {
        roomRepository.save(new Room.BuilderRoom()
            .pictureName(arg.getPictureName())
            .storey(arg.getStorey())
            .bedCount(arg.getBedCount())
            .price(arg.getPrice())
            .tvStatus(arg.getTvStatus())
            .balconyStatus(arg.getBalconyStatus())
            .fridgeStatus(arg.getFridgeStatus())
            .availableStatus(arg.getAvailableStatus())
            .build());
    }

    @Override
    public void update(RoomCreateArg arg, int roomId) {
        roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        Room room = new Room.BuilderRoom()
                .pictureName(arg.getPictureName())
                .storey(arg.getStorey())
                .bedCount(arg.getBedCount())
                .price(arg.getPrice())
                .tvStatus(arg.getTvStatus())
                .balconyStatus(arg.getBalconyStatus())
                .fridgeStatus(arg.getFridgeStatus())
                .availableStatus(arg.getAvailableStatus())
                .build();
        room.setId(roomId);

        roomRepository.save(room);
    }

    @Override
    public void delete(Integer id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        roomRepository.deleteById(id);
    }

    @Override
    public Iterable<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findAt(Integer id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        return room;
    }

    @Override
    public List<Room> findFreeRooms(String start, String end) {
        return roomRepository.findFreeRooms(start, end);
    }

}
