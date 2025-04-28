package com.ninjavin.lld.models;

import com.ninjavin.lld.enums.ParkingLotStatus;
import com.ninjavin.lld.enums.VehicleType;

public class ParkingSlot {
    private Long id;
    private VehicleType vehicleType;
    private ParkingLotStatus parkingLotStatus = ParkingLotStatus.AVAILABLE;
    private int parkingFloor;
    private Vehicle vehicle;
    private double parkingRate;

    public ParkingSlot(VehicleType vehicleType, int parkingFloor) {
        this.parkingFloor = parkingFloor;
        this.vehicleType = vehicleType;
        switch (vehicleType) {
            case CAR -> this.parkingRate = 12.00;
            case BIKE -> this.parkingRate = 8.00;
            case TRUCK -> this.parkingRate = 15.00;
            default -> this.parkingRate = 10.00;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public int getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(int parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getParkingRate() {
        return parkingRate;
    }

    public void setParkingRate(double parkingRate) {
        this.parkingRate = parkingRate;
    }

    public void assignVehicle(Vehicle vehicle) {
        if (vehicle.getVehicleType().equals(this.vehicleType)) {
            this.vehicle = vehicle;
            this.parkingLotStatus = ParkingLotStatus.BOOKED;
            return ;
        } else {
            // throw Exception that it is incorrect Slot for the input vehicle
        }
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.parkingLotStatus = ParkingLotStatus.AVAILABLE;
    }

    public boolean isAvailable() {
        return this.parkingLotStatus==ParkingLotStatus.AVAILABLE;
    }

    @Override
    public String toString() {
        return "\nParking Slot is for : " + vehicleType + ".\nParking Slot is " + parkingLotStatus + "\n";
    }
}
