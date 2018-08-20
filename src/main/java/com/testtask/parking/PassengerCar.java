package com.testtask.parking;

class PassengerCar extends Car {

    PassengerCar(Integer id) {
        super(id);
    }

    @Override
    public String toString() {
        return "PassengerCar{" + getId() + "}";
    }
}
