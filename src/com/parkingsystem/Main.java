// package com.parkingsystem;

// import com.parkingsystem.service.ParkingLot;
// import java.util.InputMismatchException;
// import java.util.Scanner;


// public class Main {
//     private static final int PARKING_CAPACITY = 20;
//     private static ParkingLot parkingLot;
//     private static Scanner scanner;

//     public static void main(String[] args) {
        
//         parkingLot = new ParkingLot(PARKING_CAPACITY);
//         scanner = new Scanner(System.in);
        
//         System.out.println("\n=============================================");
//         System.out.println("  Welcome to the Digital Parking System");
//         System.out.println("=============================================");

//         while (true) {
//             displayMenu();
//             try {
//                 int choice = scanner.nextInt();
//                 scanner.nextLine();

//                 switch (choice) {
//                     case 1:
//                         handleVehicleEntry();
//                         break;
//                     case 2:
//                         handleVehicleExit();
//                         break;
//                     case 3:
//                         parkingLot.displayStatus();
//                         break;
//                     case 4:
//                         handleSearchVehicle();
//                         break;
//                     case 5:
//                         parkingLot.viewPastRecords();
//                         break;
//                     case 6:
//                         System.out.println("Exiting System. Goodbye!");
//                         return;
//                     default:
//                         System.out.println("Invalid choice. Please try again.");
//                 }
//             } catch (InputMismatchException e) {
//                 System.out.println("Invalid input. Please enter a number.");
//                 scanner.nextLine();
//             } catch (Exception e) {
//                 System.out.println("An unexpected error occurred: " + e.getMessage());
//             }
//         }
//     }

//     private static void displayMenu() {
//         System.out.println("\n---------------------------------------------");
//         System.out.println("Please select an option:");
//         System.out.println("1. Park Vehicle (Entry)");
//         System.out.println("2. Exit Vehicle (Checkout)");
//         System.out.println("3. Display Parking Status");
//         System.out.println("4. Search for Parked Vehicle");
//         System.out.println("5. View Past Parking Records");
//         System.out.println("6. Exit Application");
//         System.out.print("Enter choice: ");
//     }

//     private static void handleVehicleEntry() {
//         System.out.print("Enter vehicle registration number (e.g., ABC-123): ");
//         String regNumber = scanner.nextLine().trim().toUpperCase();
//         if (!regNumber.isEmpty()) {
//             parkingLot.parkVehicle(regNumber);
//         } else {
//             System.out.println("Registration number cannot be empty.");
//         }
//     }

//     private static void handleVehicleExit() {
//         System.out.print("Enter the slot number to exit from: ");
//         if (scanner.hasNextInt()) {
//             int slotNumber = scanner.nextInt();
//             scanner.nextLine();
//             parkingLot.exitVehicle(slotNumber);
//         } else {
//             System.out.println("Invalid input for slot number.");
//             scanner.nextLine(); 
//         }
//     }

//     private static void handleSearchVehicle() {
//         System.out.print("Enter vehicle registration number to search: ");
//         String regNumber = scanner.nextLine().trim().toUpperCase();
//         if (!regNumber.isEmpty()) {
//             parkingLot.searchVehicle(regNumber);
//         } else {
//             System.out.println("Registration number cannot be empty.");
//         }
//     }
// }