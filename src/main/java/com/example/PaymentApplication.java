package com.example;

public class PaymentApplication {

    public static String getStatus() {
        return "Payment service is running";
    }

    public static void main(String[] args) {
        System.out.println(getStatus());
    }
}