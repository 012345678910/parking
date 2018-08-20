package com.testtask.parking;

public class ParkingPlace {
    private int id;
    private boolean isEmpty = Boolean.TRUE;
    private Type type;
    private Car car;

    public ParkingPlace(int id, Type type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "ParkingPlace{" +
                "id=" + id +
                ", isEmpty=" + isEmpty +
                ", type=" + type +
                ", car=" + car +
                '}';
    }
}
