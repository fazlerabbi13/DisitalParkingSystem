package models;

public class ParkingSlot {
    private int slotNumber;
    private boolean isOccupied;
    private Vehicle parkedVehicle;
    
    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.isOccupied = false;
        this.parkedVehicle = null;
    }
    
    public int getSlotNumber() {
        return slotNumber;
    }
    
    public boolean isOccupied() {
        return isOccupied;
    }
    
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
    
    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
    
    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
    }
    
    public Vehicle removeVehicle() {
        Vehicle vehicle = this.parkedVehicle;
        this.parkedVehicle = null;
        this.isOccupied = false;
        return vehicle;
    }
    
    @Override
    public String toString() {
        if (isOccupied) {
            return String.format("Slot %d [OCCUPIED] - %s", slotNumber, parkedVehicle.getRegistrationNumber());
        } else {
            return String.format("Slot %d [AVAILABLE]", slotNumber);
        }
    }
}
