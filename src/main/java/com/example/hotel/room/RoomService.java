package com.example.hotel.room;

public interface RoomService {

    Room create(int type, String pictureName, int storey, int bedCount, TvStatus tvStatus,
                    BalconyStatus balconyStatus, FridgeStatus fridgeStatus,
                    AvailableStatus availableStatus);
}
