package com.ninjavin.lld.models;

import com.ninjavin.lld.strategies.CashPaymentStrategy;
import com.ninjavin.lld.strategies.PaymentStrategy;
import com.ninjavin.lld.utils.IdGenerator;

import java.time.LocalDateTime;

public class Payment {
    private Long id;
    private LocalDateTime paymentTime;
    private PaymentStrategy paymentStrategy;
    private ParkingTicket parkingTicket;

    public Payment(PaymentStrategy paymentStrategy, ParkingTicket parkingTicket) {
        this.paymentStrategy = paymentStrategy;
        this.parkingTicket = parkingTicket;
        this.id = IdGenerator.generateId();
        this.paymentTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    public void makePayment(double amount) {
        this.paymentStrategy.processPayment(amount);
        return ;
    }
}
