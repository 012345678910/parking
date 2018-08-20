package com.testtask.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Generator {
    private static int id = 1;
    private Random random = new Random();

    Parking generateRandomParking() {
        List<ParkingPlace> parkingPlaces = new ArrayList<>();

        Parking parking = new Parking(10);
        for (int i = 1; i <= parking.getSize(); i++) {
            parkingPlaces.add(new ParkingPlace(generateId(), generateType()));
        }
        parking.setParkingPlaces(parkingPlaces);
        return parking;
    }

    Parking generateParking(int passCarplaces, int truckPlaces) {
        List<ParkingPlace> parkingPlaces = new ArrayList<>();

        Parking parking = new Parking(passCarplaces + truckPlaces);
        for (int i = 1; i <= passCarplaces; i++) {
            parkingPlaces.add(new ParkingPlace(generateId(), Type.PASSENGER_CAR));
        }

        for (int i = 1; i <= truckPlaces; i++) {
            parkingPlaces.add(new ParkingPlace(generateId(), Type.TRUCK));
        }
        parking.setParkingPlaces(parkingPlaces);
        return parking;
    }

    private int generateId() {
        return id++;
    }

    private Type generateType() {
        Type[] types = Type.values();
        return types[random.nextInt(2)];
    }

    List<Car> generateCars() {
        List<Car> cars = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            switch (generateType()) {
                case TRUCK:
                    cars.add(new Truck(generateId()));
                    break;
                case PASSENGER_CAR:
                    cars.add(new PassengerCar(generateId()));
                    break;
            }
        }
        System.out.println(cars);
        return cars;
    }
}
