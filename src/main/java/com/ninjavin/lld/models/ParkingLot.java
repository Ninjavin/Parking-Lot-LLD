package com.ninjavin.lld.models;

import com.ninjavin.lld.enums.VehicleType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private Long id;
    private String address;
    private List<ParkingFloor> parkingFloors = new ArrayList<>();
    private static int floorCount = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public void addParkingFloor() {
        floorCount++;
        System.out.println("Inside add parking floor : floor Count : " + floorCount);
        ParkingFloor parkingFloor = new ParkingFloor(floorCount);
        this.parkingFloors.add(parkingFloor);
    }

    public ParkingSlot findAvailableSlot(Vehicle vehicle) {
        VehicleType vehicleType = vehicle.getVehicleType();
        System.out.println("Inside findAvailableSlot : vehicletype : " + vehicleType);
        for (ParkingFloor parkingFloor: parkingFloors) {
            System.out.println("Inside findAvailableSlot : parkingFloor : " + parkingFloor.toString());
            ParkingSlot parkingSlot = parkingFloor.findAvailableSlot(vehicleType);
            System.out.println("Inside findAvailableSlot : parkingSlot : " + parkingSlot.toString());
            if (parkingSlot != null) {
                return parkingSlot;
            }
        }
        return null;
    }

    public ParkingTicket generateParkingTicket(Vehicle vehicle) {
        ParkingSlot parkingSlot = this.findAvailableSlot(vehicle);
        if (parkingSlot == null)
            return null;
        ParkingTicket parkingTicket = new ParkingTicket(vehicle, LocalDateTime.now(), parkingSlot);
        return parkingTicket;
    }

    @Override
    public String toString() {
        String res = "\n----------- Parking Lot Info ----------- \nNumber of floors : " + floorCount;
        return res;
    }
}
