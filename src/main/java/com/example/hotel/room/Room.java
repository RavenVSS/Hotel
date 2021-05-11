package com.example.hotel.room;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private int type;
    private String pictureName;
    private int storey;
    private int bedCount;
    private AvailableStatus tvStatus;
    private AvailableStatus balconyStatus;
    private AvailableStatus fridgeStatus;
    private AvailableStatus availableStatus;

    public int getType() {
        return type;
    }

    public String getPictureName() {
        return pictureName;
    }

    public int getStorey() {
        return storey;
    }

    public int getBedCount() {
        return bedCount;
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
        private int type;
        private String pictureName;
        private int storey;
        private int bedCount;
        private AvailableStatus tvStatus;
        private AvailableStatus balconyStatus;
        private  AvailableStatus fridgeStatus;
        private  AvailableStatus availableStatus;

        public BuilderRoom type(int value) {
            this.type = value;
            return this;
        }

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
        this.type = 0;
        this.pictureName = "";
        this.storey = -1;
        this.bedCount = -1;
        this.tvStatus = AvailableStatus.NOT_AVAILABLE;
        this.balconyStatus = AvailableStatus.NOT_AVAILABLE;
        this.fridgeStatus = AvailableStatus.NOT_AVAILABLE;
        this.availableStatus = AvailableStatus.NOT_AVAILABLE;
    }

    public Room(BuilderRoom builderRoom) {
        this.type = builderRoom.type;
        this.pictureName = builderRoom.pictureName;
        this.storey = builderRoom.storey;
        this.bedCount = builderRoom.bedCount;
        this.tvStatus = builderRoom.tvStatus;
        this.balconyStatus = builderRoom.balconyStatus;
        this.fridgeStatus = builderRoom.fridgeStatus;
        this.availableStatus = builderRoom.availableStatus;
    }

    @Override
    public String toString() {
        return "type:" + type + " picName:" + pictureName + " storey:" + storey
                + " bedCount:" + bedCount + " tvStatus:" + tvStatus + " balconyStatus:" + balconyStatus
                + " fridgeStatus:" + fridgeStatus + " availableStatus:" + availableStatus;
    }
}
