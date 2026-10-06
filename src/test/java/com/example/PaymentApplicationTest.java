package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentApplicationTest {

    @Test
    void paymentStatusShouldBeRunning() {
        assertEquals(
            "Payment service is running",
            PaymentApplication.getStatus()
        );
    }
}