package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkingRecord {
    private String registrationNumber;
    private String vehicleType;
    private String ownerName;
    private int slotNumber;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double parkingFee;
    private long durationInMinutes;
    
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    
    public ParkingRecord(Vehicle vehicle, int slotNumber, LocalDateTime exitTime, 
                        double parkingFee, long durationInMinutes) {
        this.registrationNumber = vehicle.getRegistrationNumber();
        this.vehicleType = vehicle.getVehicleType();
        this.ownerName = vehicle.getOwnerName();
        this.slotNumber = slotNumber;
        this.entryTime = vehicle.getEntryTime();
        this.exitTime = exitTime;
        this.parkingFee = parkingFee;
        this.durationInMinutes = durationInMinutes;
    }
    
    // Getters
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    
    public String getVehicleType() {
        return vehicleType;
    }
    
    public String getOwnerName() {
        return ownerName;
    }
    
    public int getSlotNumber() {
        return slotNumber;
    }
    
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    
    public LocalDateTime getExitTime() {
        return exitTime;
    }
    
    public double getParkingFee() {
        return parkingFee;
    }
    
    public long getDurationInMinutes() {
        return durationInMinutes;
    }
    
    public String getFormattedDuration() {
        long hours = durationInMinutes / 60;
        long minutes = durationInMinutes % 60;
        return String.format("%d hrs %d mins", hours, minutes);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append("─".repeat(60)).append("\n");
        sb.append(String.format("Registration No: %s\n", registrationNumber));
        sb.append(String.format("Vehicle Type   : %s\n", vehicleType));
        sb.append(String.format("Owner Name     : %s\n", ownerName));
        sb.append(String.format("Slot Number    : %d\n", slotNumber));
        sb.append(String.format("Entry Time     : %s\n", entryTime.format(formatter)));
        sb.append(String.format("Exit Time      : %s\n", exitTime.format(formatter)));
        sb.append(String.format("Duration       : %s\n", getFormattedDuration()));
        sb.append(String.format("Parking Fee    : ৳%.2f\n", parkingFee));
        sb.append("─".repeat(60));
        return sb.toString();
    }
    
    public String toFileString() {
        return String.format("%s|%s|%s|%d|%s|%s|%.2f|%d",
                registrationNumber, vehicleType, ownerName, slotNumber,
                entryTime.format(formatter), exitTime.format(formatter),
                parkingFee, durationInMinutes);
    }
}