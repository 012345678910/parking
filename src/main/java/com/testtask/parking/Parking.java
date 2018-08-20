package com.testtask.parking;

import java.util.List;

public class Parking {
    private int size;
    private List<ParkingPlace> parkingPlaces;

    Parking(int size) {
        this.size = size;
    }

    int getSize() {
        return size;
    }


    private List<ParkingPlace> getParkingPlaces() {
        return parkingPlaces;
    }

    void setParkingPlaces(List<ParkingPlace> parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }

    void leaveParking() {
        if (getParkingPlaces() == null) return;
        ParkingPlace place = getParkingPlaces().stream().filter(v -> v != null && !v.isEmpty()).findAny().get();
        if (place.getCar() instanceof Truck && place.getType().equals(Type.PASSENGER_CAR)) {
            getParkingPlaces().stream().filter(v ->
                    v != null && (v.getId() == place.getId() - 1 || v.getId() == place.getId() + 1) && v.getCar() != null && v.getCar().getId().equals(place.getCar().getId()))
                    .findFirst().ifPresent(secondPlace -> {
                secondPlace.setEmpty(true);
                secondPlace.setCar(null);
            });
        }

        place.setEmpty(true);
        place.setCar(null);

        System.out.println("Автомобиль осводил место номер " + place.getId());
    }

    void parkIn(Car car) {
        System.out.println("Автомобиль с номером " + car.getId() + " пытается заехать на парковку");
        if (car instanceof Truck) {
            ParkingPlace parkingPlace = getParkingPlaces().stream()
                    .filter(v -> v != null && v.isEmpty() && v.getType().equals(Type.TRUCK))
                    .findAny().orElse(null);
            if (parkingPlace == null) {
                ParkingPlace passengerCarPlace = getParkingPlaces().stream()
                        .filter(v -> v != null && v.isEmpty() && v.getType().equals(Type.PASSENGER_CAR)
                                && (v.getId() > 1 && parkingPlaces.get(v.getId() - 2).isEmpty() || v.getId() < size && parkingPlaces.get(v.getId()).isEmpty()))
                        .findAny().orElse(null);
                if (passengerCarPlace == null) {
                    System.out.println("Нет мест для автомобиля с номером " + car.getId());
                    return;
                }
                passengerCarPlace.setCar(car);
                passengerCarPlace.setEmpty(Boolean.FALSE);
                getParkingPlaces().stream()
                        .filter(v -> v != null && v.isEmpty() && v.getType().equals(Type.PASSENGER_CAR)
                                && (passengerCarPlace.getId() > 1 && parkingPlaces.get(passengerCarPlace.getId() - 2).isEmpty() || passengerCarPlace.getId() < size && parkingPlaces.get(passengerCarPlace.getId()).isEmpty()))
                        .findAny().ifPresent(p -> {
                    p.setCar(car);
                    p.setEmpty(Boolean.FALSE);
                });
                System.out.println("Припарковался грузовой автомобиль с номером " + car.getId());
                return;
            }
            parkingPlace.setCar(car);
            parkingPlace.setEmpty(Boolean.FALSE);
            System.out.println("Припарковался грузовой автомобиль с номером " + car.getId() + " на место " + parkingPlace.getId());
        }

        if (car instanceof PassengerCar) {
            ParkingPlace parkingPlace = getParkingPlaces().stream()
                    .filter(v -> v != null && v.isEmpty() && v.getType().equals(Type.PASSENGER_CAR))
                    .findAny().orElse(null);
            if (parkingPlace == null) {
                System.out.println("Нет мест для автомобиля с номером " + car.getId());
                return;
            }
            parkingPlace.setCar(car);
            parkingPlace.setEmpty(Boolean.FALSE);
            System.out.println("Припарковался легковой автомобиль с номером " + car.getId() + " на место " + parkingPlace.getId());
        }
    }

    @Override
    public String toString() {
        return "Parking{" +
                "parkingPlaces=" + parkingPlaces +
                '}';
    }
}
