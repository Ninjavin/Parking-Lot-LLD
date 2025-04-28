package com.ninjavin.lld;

import com.ninjavin.lld.enums.VehicleType;
import com.ninjavin.lld.models.ParkingFloor;
import com.ninjavin.lld.models.ParkingLot;
import com.ninjavin.lld.models.ParkingTicket;
import com.ninjavin.lld.models.Vehicle;
import com.ninjavin.lld.strategies.CashPaymentStrategy;

import java.util.List;

public class ParkingLotSystem {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addParkingFloor();
        parkingLot.addParkingFloor();
        System.out.println(parkingLot.toString());

        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        if (parkingFloors != null) {
            for (ParkingFloor parkingFloor: parkingFloors) {
                int floorNumber = parkingFloor.getFloorNumber();
                parkingFloor.addParkingSlot(floorNumber, VehicleType.BIKE);
                parkingFloor.addParkingSlot(floorNumber, VehicleType.CAR);
                parkingFloor.addParkingSlot(floorNumber, VehicleType.TRUCK);
            }
        }

        if (parkingFloors != null) {
            for (ParkingFloor parkingFloor : parkingFloors) {
                System.out.println(parkingFloor.toString());
            }
        }

        Vehicle car1 = new Vehicle("Car12025", VehicleType.CAR);
        ParkingTicket carParkingTicket = parkingLot.generateParkingTicket(car1);
        System.out.println(carParkingTicket.toString());

        Vehicle car2 = new Vehicle("Car22025", VehicleType.CAR);
        ParkingTicket carParkingTicket2 = parkingLot.generateParkingTicket(car2);
        System.out.println(carParkingTicket2.toString());

        carParkingTicket.payAndProcessExit(new CashPaymentStrategy());
    }
}
