package com.ninjavin.lld.models;

import com.ninjavin.lld.strategies.PaymentStrategy;
import com.ninjavin.lld.utils.IdGenerator;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingTicket {
    private Long id;
    private Vehicle vehicle;
    private double amount = 0.0;
    private LocalDateTime entryTime;
    private ParkingSlot parkingSlot;

    public ParkingTicket(Vehicle vehicle, LocalDateTime entryTime, ParkingSlot parkingSlot) {
        this.id = IdGenerator.generateId();
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.parkingSlot = parkingSlot;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public void payAndProcessExit(PaymentStrategy paymentStrategy) {
        double rate = calculateRate();
        Payment payment = new Payment(paymentStrategy, this);
        payment.makePayment(rate);
    }

    public double calculateRate() {
        LocalDateTime currTime = LocalDateTime.now();
        Duration duration = Duration.between(this.entryTime, currTime);
        long minutes = duration.toMillis();
        double rate = this.parkingSlot.getParkingRate()*minutes;
        return rate;
    }

    @Override
    public String toString() {
        return "\nParking ticket : " + this.id + " generated for time : " + this.entryTime + " and vehicle " + vehicle.toString();
    }
}
