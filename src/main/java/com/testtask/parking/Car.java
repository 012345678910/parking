package com.testtask.parking;

abstract class Car {

    private Integer id;

    Car(Integer id) {
        this.id = id;
    }

    Integer getId() {
        return id;
    }

}
