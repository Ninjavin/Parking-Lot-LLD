package com.ninjavin.lld.models;

import com.ninjavin.lld.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private Long id;
    private int floorNumber;
    private List<ParkingSlot> parkingSlots = new ArrayList<>();

    public ParkingFloor(int floorNumber) {
        this.parkingSlots = new ArrayList<>();
        this.floorNumber = floorNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public void addParkingSlot(int floorNumber, VehicleType vehicleType) {
        ParkingSlot parkingSlot = new ParkingSlot(vehicleType, floorNumber);
        this.parkingSlots.add(parkingSlot);
    }

    public ParkingSlot findAvailableSlot(VehicleType vehicleType) {
        System.out.println("Inside findAvailableSlot 2 : vehicleType : " + vehicleType);
        for (ParkingSlot parkingSlot : parkingSlots) {
            System.out.println("Inside findAvailableSlot 2 : parkingSlot : " + parkingSlot.toString());
            if (parkingSlot.isAvailable() && parkingSlot.getVehicleType().equals(vehicleType)) {
                return parkingSlot;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String res = "\nParking Floor " + this.floorNumber + "has " + parkingSlots.size() + " slots.\n";
        for (ParkingSlot parkingSlot: parkingSlots) {
            res += parkingSlot.toString();
        }
        return res;
    }
}
