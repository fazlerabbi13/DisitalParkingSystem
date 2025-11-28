package com.parkingsystem.service;

import com.parkingsystem.model.ParkingRecord;
import com.parkingsystem.model.Vehicle;
import com.parkingsystem.util.ParkingFeeCalculator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private final Map<Integer, Vehicle> slots;
    private final List<ParkingRecord> historyRecords;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.slots = new HashMap<>();
        this.historyRecords = new ArrayList<>();
       
        for (int i = 1; i <= capacity; i++) {
            slots.put(i, null);
        }
        System.out.println("Parking Lot created with " + capacity + " slots.");
    }

    public int parkVehicle(String registrationNumber) {
        if (isVehicleParked(registrationNumber)) {
            System.out.println("Error: Vehicle " + registrationNumber + " is already parked.");
            return -1;
        }

        for (int i = 1; i <= capacity; i++) {
            if (slots.get(i) == null) {
                Vehicle vehicle = new Vehicle(registrationNumber);
                slots.put(i, vehicle);
                System.out.println("\nVehicle " + registrationNumber + " parked at Slot " + i + ".");
                return i;
            }
        }
        System.out.println("\nSorry, the parking lot is full.");
        return -1;
    }
    public double exitVehicle(int slotNumber) {
        if (slotNumber < 1 || slotNumber > capacity || slots.get(slotNumber) == null) {
            System.out.println("Error: Invalid slot number or slot is already empty.");
            return -1.0;
        }

        Vehicle vehicle = slots.get(slotNumber);
        LocalDateTime exitTime = LocalDateTime.now();
        double fee = ParkingFeeCalculator.calculateFee(vehicle.getEntryTime(), exitTime);

        // Record the transaction
        ParkingRecord record = new ParkingRecord(
                vehicle.getRegistrationNumber(),
                vehicle.getEntryTime(),
                exitTime,
                fee
        );
        historyRecords.add(record);

        
        slots.put(slotNumber, null);

        System.out.println("\nVehicle " + vehicle.getRegistrationNumber() + " exited from Slot " + slotNumber + ".");
        System.out.printf("Parking Fee: $%.2f\n", fee);

        return fee;
    }

    public boolean isVehicleParked(String registrationNumber) {
        return slots.values().stream()
                .anyMatch(v -> v != null && v.getRegistrationNumber().equalsIgnoreCase(registrationNumber));
    }

    public void displayStatus() {
        int occupiedCount = 0;
        System.out.println("\n--- Parking Lot Status (Capacity: " + capacity + ") ---");
        System.out.println("Slot | Status   | Vehicle/Entry Time");
        System.out.println("-------------------------------------");

        for (int i = 1; i <= capacity; i++) {
            Vehicle vehicle = slots.get(i);
            String status;
            String vehicleInfo;

            if (vehicle == null) {
                status = "FREE";
                vehicleInfo = "-";
            } else {
                status = "OCCUPIED";
                vehicleInfo = vehicle.toString();
                occupiedCount++;
            }
            System.out.printf("%4d | %-8s | %s\n", i, status, vehicleInfo);
        }
        System.out.println("-------------------------------------");
        System.out.println("Total Occupied: " + occupiedCount + " | Total Free: " + (capacity - occupiedCount));
    }

    public void searchVehicle(String registrationNumber) {
        for (Map.Entry<Integer, Vehicle> entry : slots.entrySet()) {
            Vehicle vehicle = entry.getValue();
            if (vehicle != null && vehicle.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                System.out.println("\nVehicle " + registrationNumber + " is currently parked at Slot " + entry.getKey() + ".");
                System.out.println("Entry Time: " + vehicle.getEntryTime().toLocalTime().withNano(0));
                return;
            }
        }
        System.out.println("\nVehicle " + registrationNumber + " is not currently parked.");
    }

    public void viewPastRecords() {
        if (historyRecords.isEmpty()) {
            System.out.println("\nNo past parking records available.");
            return;
        }
        System.out.println("\n--- Parking Transaction History ---");
        historyRecords.forEach(System.out::println);
        double totalEarnings = historyRecords.stream().mapToDouble(ParkingRecord::getFee).sum();
        System.out.printf("\nTotal Earnings from Records: $%.2f\n", totalEarnings);
    }
}