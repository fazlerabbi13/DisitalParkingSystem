package com.parkingsystem.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingRecord {
    private final String registrationNumber;
    private final LocalDateTime entryTime;
    private final LocalDateTime exitTime;
    private final double fee;

    public ParkingRecord(String registrationNumber, LocalDateTime entryTime, LocalDateTime exitTime, double fee) {
        this.registrationNumber = registrationNumber;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.fee = fee;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public double getFee() {
        return fee;
    }

    @Override
    public String toString() {
        long durationMinutes = ChronoUnit.MINUTES.between(entryTime, exitTime);
        return String.format("Reg: %-10s | Entry: %-15s | Exit: %-15s | Duration: %-6s | Fee: $%.2f",
                registrationNumber,
                entryTime.toLocalTime().withNano(0),
                exitTime.toLocalTime().withNano(0),
                durationMinutes + " min",
                fee);
    }
}