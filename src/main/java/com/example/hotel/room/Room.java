package com.example.hotel.room;

public class Room {
    int type;
    String pictureName;
    int storey;
    int bedCount;
    TvStatus tvStatus;
    BalconyStatus balconyStatus;
    FridgeStatus fridgeStatus;
    AvailableStatus availableStatus;

    public Room(int type, String pictureName, int storey, int bedCount, TvStatus tvStatus,
                BalconyStatus balconyStatus, FridgeStatus fridgeStatus,
                AvailableStatus availableStatus) {
        this.type = type;
        this.pictureName = pictureName;
        this.storey = storey;
        this.bedCount = bedCount;
        this.tvStatus = tvStatus;
        this.balconyStatus = balconyStatus;
        this.fridgeStatus = fridgeStatus;
        this.availableStatus = availableStatus;
    }

    public String getString() {
        return "type:" + type + " picName:" + pictureName + " storey:" + storey
                + " bedCount:" + bedCount + " tvStatus:" + tvStatus + " balconyStatus:" + balconyStatus
                + " fridgeStatus:" + fridgeStatus + " availableStatus:" + availableStatus;
    }
}
