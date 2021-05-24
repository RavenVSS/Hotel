package com.example.hotel.room.dto;

import com.example.hotel.room.AvailableStatus;

public class RoomDto {
    private int roomId;
    private String pictureName;
    private int storey;
    private int bedCount;
    private int price;
    private AvailableStatus tvStatus;
    private AvailableStatus balconyStatus;
    private AvailableStatus fridgeStatus;
    private AvailableStatus availableStatus;

    public RoomDto() {

    }

    public RoomDto(BuilderRoomDto builderRoomDto) {
        this.roomId = builderRoomDto.roomId;
        this.pictureName = builderRoomDto.pictureName;
        this.storey = builderRoomDto.storey;
        this.bedCount = builderRoomDto.bedCount;
        this.price = builderRoomDto.price;
        this.tvStatus = builderRoomDto.tvStatus;
        this.balconyStatus = builderRoomDto.balconyStatus;
        this.fridgeStatus = builderRoomDto.fridgeStatus;
        this.availableStatus = builderRoomDto.availableStatus;
    }

    public RoomDto(int roomId, String pictureName, int storey, int bedCount, int price,
                   AvailableStatus tvStatus, AvailableStatus balconyStatus,
                   AvailableStatus fridgeStatus, AvailableStatus availableStatus) {
        this.roomId = roomId;
        this.pictureName = pictureName;
        this.storey = storey;
        this.bedCount = bedCount;
        this.price = price;
        this.tvStatus = tvStatus;
        this.balconyStatus = balconyStatus;
        this.fridgeStatus = fridgeStatus;
        this.availableStatus = availableStatus;
    }

    public static class BuilderRoomDto {
        private int roomId;
        private String pictureName;
        private int storey;
        private int bedCount;
        private int price;
        private AvailableStatus tvStatus;
        private AvailableStatus balconyStatus;
        private AvailableStatus fridgeStatus;
        private AvailableStatus availableStatus;

        public RoomDto.BuilderRoomDto roomId(int value) {
            this.roomId = value;
            return this;
        }

        public RoomDto.BuilderRoomDto pictureName(String value) {
            this.pictureName = value;
            return this;
        }

        public RoomDto.BuilderRoomDto storey(int value) {
            this.storey = value;
            return this;
        }

        public RoomDto.BuilderRoomDto bedCount(int value) {
            this.bedCount = value;
            return this;
        }

        public RoomDto.BuilderRoomDto price(int value) {
            this.price = value;
            return this;
        }

        public RoomDto.BuilderRoomDto tvStatus(AvailableStatus value) {
            this.tvStatus = value;
            return this;
        }

        public RoomDto.BuilderRoomDto balconyStatus(AvailableStatus value) {
            this.balconyStatus = value;
            return this;
        }

        public RoomDto.BuilderRoomDto fridgeStatus(AvailableStatus value) {
            this.fridgeStatus = value;
            return this;
        }

        public RoomDto.BuilderRoomDto availableStatus(AvailableStatus value) {
            this.availableStatus = value;
            return this;
        }

        public RoomDto build() {
            return new RoomDto(this);
        }
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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
