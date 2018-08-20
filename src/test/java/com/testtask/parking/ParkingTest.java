package com.testtask.parking;

import org.junit.Test;

public class ParkingTest {

    @Test
    public void test() {
        Generator generator = new Generator();
        Parking parking = generator.generateParking(10, 5);
        generator.generateCars().forEach(parking::parkIn);
        for (int i = 0; i < 5; i++) {
            parking.leaveParking();
        }
        generator.generateCars().forEach(parking::parkIn);
    }
}
