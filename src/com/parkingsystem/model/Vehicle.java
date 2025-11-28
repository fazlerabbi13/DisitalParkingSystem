package com.parkingsystem.model;

import java.time.LocalDateTime;

public class Vehicle {
    private final String registrationNumber;
    private final LocalDateTime entryTime;

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        this.entryTime = LocalDateTime.now();
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    @Override
    public String toString() {
        return "Vehicle [Reg=" + registrationNumber + ", Entry=" + entryTime.toLocalTime().withNano(0) + "]";
    }
}