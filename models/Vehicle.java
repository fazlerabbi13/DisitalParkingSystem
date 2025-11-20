package models;

import java.time.LocalDateTime;

public class Vehicle {
    private String registrationNumber;
    private String vehicleType;
    private String ownerName;
    private LocalDateTime entryTime;

    public Vehicle(String registrationNumber, String vehicleType, String ownerName) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.ownerName = ownerName;
        this.entryTime = LocalDateTime.now();
    }

    // Getters and Setters
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        return String.format("Vehicle[Reg: %s, Type: %s, Owner: %s, Entry: %s]",
                registrationNumber, vehicleType, ownerName, entryTime);
    }
}
