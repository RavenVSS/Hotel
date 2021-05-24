package com.example.hotel.room;

public class RoomCreateArg {
    private String pictureName;
    private int storey;
    private int bedCount;
    private int price;
    private AvailableStatus tvStatus;
    private AvailableStatus balconyStatus;
    private AvailableStatus fridgeStatus;
    private AvailableStatus availableStatus;

    public RoomCreateArg(String pictureName, int storey, int bedCount, int price,
                         AvailableStatus tvStatus, AvailableStatus balconyStatus,
                         AvailableStatus fridgeStatus, AvailableStatus availableStatus) {
        this.pictureName = pictureName;
        this.storey = storey;
        this.bedCount = bedCount;
        this.price = price;
        this.tvStatus = tvStatus;
        this.balconyStatus = balconyStatus;
        this.fridgeStatus = fridgeStatus;
        this.availableStatus = availableStatus;
    }

    public RoomCreateArg(RoomCreateArg.BuilderRoomCreateArg builderRoomCreateArg) {
        this.pictureName = builderRoomCreateArg.pictureName;
        this.storey = builderRoomCreateArg.storey;
        this.bedCount = builderRoomCreateArg.bedCount;
        this.price = builderRoomCreateArg.price;
        this.tvStatus = builderRoomCreateArg.tvStatus;
        this.balconyStatus = builderRoomCreateArg.balconyStatus;
        this.fridgeStatus = builderRoomCreateArg.fridgeStatus;
        this.availableStatus = builderRoomCreateArg.availableStatus;
    }

    public static class BuilderRoomCreateArg {
        private String pictureName;
        private int storey;
        private int bedCount;
        private int price;
        private AvailableStatus tvStatus;
        private AvailableStatus balconyStatus;
        private AvailableStatus fridgeStatus;
        private AvailableStatus availableStatus;

        public RoomCreateArg.BuilderRoomCreateArg pictureName(String value) {
            this.pictureName = value;
            return this;
        }

        public RoomCreateArg.BuilderRoomCreateArg storey(int value) {
            this.storey = value;
            return this;
        }

        public RoomCreateArg.BuilderRoomCreateArg bedCount(int value) {
            this.bedCount = value;
            return this;
        }

        public RoomCreateArg.BuilderRoomCreateArg price(int value) {
            this.price = value;
            return this;
        }

        public RoomCreateArg.BuilderRoomCreateArg tvStatus(AvailableStatus value) {
            this.tvStatus = value;
            return this;
        }

        public RoomCreateArg.BuilderRoomCreateArg balconyStatus(AvailableStatus value) {
            this.balconyStatus = value;
            return this;
        }

        public RoomCreateArg.BuilderRoomCreateArg fridgeStatus(AvailableStatus value) {
            this.fridgeStatus = value;
            return this;
        }

        public RoomCreateArg.BuilderRoomCreateArg availableStatus(AvailableStatus value) {
            this.availableStatus = value;
            return this;
        }

        public RoomCreateArg build() {
            return new RoomCreateArg(this);
        }
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public AvailableStatus getTvStatus() {
        return tvStatus;
    }

    public void setTvStatus(AvailableStatus tvStatus) {
        this.tvStatus = tvStatus;
    }

    public AvailableStatus getBalconyStatus() {
        return balconyStatus;
    }

    public void setBalconyStatus(AvailableStatus balconyStatus) {
        this.balconyStatus = balconyStatus;
    }

    public AvailableStatus getFridgeStatus() {
        return fridgeStatus;
    }

    public void setFridgeStatus(AvailableStatus fridgeStatus) {
        this.fridgeStatus = fridgeStatus;
    }

    public AvailableStatus getAvailableStatus() {
        return availableStatus;
    }

    public void setAvailableStatus(AvailableStatus availableStatus) {
        this.availableStatus = availableStatus;
    }
}
