package com.freelancex.notificationservice.dto.event.payment;

import java.util.UUID;

public class PaymentCompletedEvent {

    private UUID userId;
    private UUID contractId;
    private double amount;

    public PaymentCompletedEvent() {
        // Default constructor
    }

    public PaymentCompletedEvent(UUID userId, UUID contractId, double amount) {
        this.userId = userId;
        this.contractId = contractId;
        this.amount = amount;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getContractId() {
        return contractId;
    }

    public void setContractId(UUID contractId) {
        this.contractId = contractId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
