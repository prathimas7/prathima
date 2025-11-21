package com.smartbank.model;
import java.time.LocalDateTime;
public class Transaction {
    private String transactionId;
    private String type;
    private double amount;
    private LocalDateTime time;
    public Transaction(String transactionId, String type, double amount) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.time = LocalDateTime.now();
    }
    public String toString() {
        return "[" + transactionId + "] " + type + " ₹" + amount + " at " + time;
    }
}
