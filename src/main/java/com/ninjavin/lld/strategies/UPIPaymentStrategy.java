package com.ninjavin.lld.strategies;

public class UPIPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment for amount : " + amount);
    }
}
