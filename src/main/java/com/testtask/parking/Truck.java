package com.testtask.parking;

class Truck extends Car {

    Truck(Integer id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Truck{" + getId() + "}";
    }
}
