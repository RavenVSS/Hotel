package com.example.hotel.service.rooms;

import com.example.hotel.exceptions.RoomNotFoundException;
import com.example.hotel.model.rooms.RoomCreateArg;
import com.example.hotel.model.rooms.Room;
import com.example.hotel.repository.rooms.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    @Transactional
    public void create(RoomCreateArg arg) {
        roomRepository.save(Room.builder()
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
    @Transactional
    public void update(RoomCreateArg arg, int roomId) {
        roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException());

        Room room = Room.builder()
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
    @Transactional
    public void delete(Integer id) {
        roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException());
        roomRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Room findAt(Integer id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException());
        return room;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Room> findFreeRooms(Date start, Date end) {
        return roomRepository.findFreeRooms(start, end);
    }

}
