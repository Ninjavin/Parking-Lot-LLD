package com.ninjavin.lld.strategies;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cash payment for amount : " + amount);
    }
}
