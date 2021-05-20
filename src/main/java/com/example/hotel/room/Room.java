package com.example.hotel.room;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "picture_name")
    private String pictureName;

    @Column(name = "storey")
    private int storey;

    @Column(name = "bed_count")
    private int bedCount;

    @Column(name = "price")
    private int price;

    @Column(name = "tv_status")
    private AvailableStatus tvStatus;

    @Column(name = "balcony_status")
    private AvailableStatus balconyStatus;

    @Column(name = "fridge_status")
    private AvailableStatus fridgeStatus;

    @Column(name = "available_status")
    private AvailableStatus availableStatus;

    public String getPictureName() {
        return pictureName;
    }

    public int getStorey() {
        return storey;
    }

    public int getBedCount() {
        return bedCount;
    }

    public int getPrice() {
        return price;
    }

    public AvailableStatus getTvStatus() {
        return tvStatus;
    }

    public AvailableStatus getBalconyStatus() {
        return balconyStatus;
    }

    public AvailableStatus getFridgeStatus() {
        return fridgeStatus;
    }

    public AvailableStatus getAvailableStatus() {
        return availableStatus;
    }

    public static class BuilderRoom {
        private String pictureName;
        private int storey;
        private int bedCount;
        private int price;
        private AvailableStatus tvStatus;
        private AvailableStatus balconyStatus;
        private  AvailableStatus fridgeStatus;
        private  AvailableStatus availableStatus;

        public BuilderRoom pictureName(String value) {
            this.pictureName = value;
            return this;
        }

        public BuilderRoom storey(int value) {
            this.storey = value;
            return this;
        }

        public BuilderRoom bedCount(int value) {
            this.bedCount = value;
            return this;
        }

        public BuilderRoom price(int value) {
            this.price = value;
            return this;
        }

        public BuilderRoom tvStatus(AvailableStatus value) {
            this.tvStatus = value;
            return this;
        }

        public BuilderRoom balconyStatus(AvailableStatus value) {
            this.balconyStatus = value;
            return this;
        }

        public BuilderRoom fridgeStatus(AvailableStatus value) {
            this.fridgeStatus = value;
            return this;
        }

        public BuilderRoom availableStatus(AvailableStatus value) {
            this.availableStatus = value;
            return this;
        }

        public Room build() {
            return new Room(this);
        }
    }

    public Room() {
        this.pictureName = "";
        this.storey = -1;
        this.bedCount = -1;
        this.price = 0;
        this.tvStatus = AvailableStatus.NOT_AVAILABLE;
        this.balconyStatus = AvailableStatus.NOT_AVAILABLE;
        this.fridgeStatus = AvailableStatus.NOT_AVAILABLE;
        this.availableStatus = AvailableStatus.NOT_AVAILABLE;
    }

    public Room(BuilderRoom builderRoom) {
        this.pictureName = builderRoom.pictureName;
        this.storey = builderRoom.storey;
        this.bedCount = builderRoom.bedCount;
        this.price = builderRoom.price;
        this.tvStatus = builderRoom.tvStatus;
        this.balconyStatus = builderRoom.balconyStatus;
        this.fridgeStatus = builderRoom.fridgeStatus;
        this.availableStatus = builderRoom.availableStatus;
    }

    @Override
    public String toString() {
        return " picName:" + pictureName + " storey:" + storey
                + " bedCount:" + bedCount + " price:" + price + " tvStatus:" + tvStatus + " balconyStatus:" + balconyStatus
                + " fridgeStatus:" + fridgeStatus + " availableStatus:" + availableStatus;
    }
}
