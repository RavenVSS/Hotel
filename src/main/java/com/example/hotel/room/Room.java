package com.example.hotel.room;

public class Room {
    private int type;
    private String pictureName;
    private int storey;
    private int bedCount;
    private AvailableStatus tvStatus;
    private AvailableStatus balconyStatus;
    private  AvailableStatus fridgeStatus;
    private  AvailableStatus availableStatus;

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

    public String getString() {
        return "type:" + type + " picName:" + pictureName + " storey:" + storey
                + " bedCount:" + bedCount + " tvStatus:" + tvStatus + " balconyStatus:" + balconyStatus
                + " fridgeStatus:" + fridgeStatus + " availableStatus:" + availableStatus;
    }
}
