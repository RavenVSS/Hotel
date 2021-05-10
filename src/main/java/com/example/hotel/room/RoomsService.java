package com.example.hotel.room;

public class RoomsService implements RoomService {

    public Room create(int type, String pictureName, int storey, int bedCount, TvStatus tvStatus,
                       BalconyStatus balconyStatus, FridgeStatus fridgeStatus,
                       AvailableStatus availableStatus) {
        return new Room(type, pictureName, storey, bedCount, tvStatus, balconyStatus, fridgeStatus, availableStatus);
    }
}
