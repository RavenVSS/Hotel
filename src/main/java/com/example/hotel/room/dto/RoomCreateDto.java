package com.example.hotel.room.dto;

import com.example.hotel.room.AvailableStatus;

public class RoomCreateDto {
    private String pictureName;
    private int storey;
    private int bedCount;
    private int price;
    private AvailableStatus tvStatus;
    private AvailableStatus balconyStatus;
    private AvailableStatus fridgeStatus;
    private AvailableStatus availableStatus;

    public RoomCreateDto() {
    }

    public RoomCreateDto(RoomCreateDto.BuilderRoomCreateDto builderRoomCreateDto) {
        this.pictureName = builderRoomCreateDto.pictureName;
        this.storey = builderRoomCreateDto.storey;
        this.bedCount = builderRoomCreateDto.bedCount;
        this.price = builderRoomCreateDto.price;
        this.tvStatus = builderRoomCreateDto.tvStatus;
        this.balconyStatus = builderRoomCreateDto.balconyStatus;
        this.fridgeStatus = builderRoomCreateDto.fridgeStatus;
        this.availableStatus = builderRoomCreateDto.availableStatus;
    }

    public RoomCreateDto(String pictureName, int storey, int bedCount, int price,
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

    public static class BuilderRoomCreateDto {
        private String pictureName;
        private int storey;
        private int bedCount;
        private int price;
        private AvailableStatus tvStatus;
        private AvailableStatus balconyStatus;
        private AvailableStatus fridgeStatus;
        private AvailableStatus availableStatus;

        public RoomCreateDto.BuilderRoomCreateDto pictureName(String value) {
            this.pictureName = value;
            return this;
        }

        public RoomCreateDto.BuilderRoomCreateDto storey(int value) {
            this.storey = value;
            return this;
        }

        public RoomCreateDto.BuilderRoomCreateDto bedCount(int value) {
            this.bedCount = value;
            return this;
        }

        public RoomCreateDto.BuilderRoomCreateDto price(int value) {
            this.price = value;
            return this;
        }

        public RoomCreateDto.BuilderRoomCreateDto tvStatus(AvailableStatus value) {
            this.tvStatus = value;
            return this;
        }

        public RoomCreateDto.BuilderRoomCreateDto balconyStatus(AvailableStatus value) {
            this.balconyStatus = value;
            return this;
        }

        public RoomCreateDto.BuilderRoomCreateDto fridgeStatus(AvailableStatus value) {
            this.fridgeStatus = value;
            return this;
        }

        public RoomCreateDto.BuilderRoomCreateDto availableStatus(AvailableStatus value) {
            this.availableStatus = value;
            return this;
        }

        public RoomCreateDto build() {
            return new RoomCreateDto(this);
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
