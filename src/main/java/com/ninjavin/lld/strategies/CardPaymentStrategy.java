package com.ninjavin.lld.strategies;

public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing card payment for amount : " + amount);
    }
}
