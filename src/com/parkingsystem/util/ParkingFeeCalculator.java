// package com.parkingsystem.util;

// import java.time.LocalDateTime;
// import java.time.temporal.ChronoUnit;

// public class ParkingFeeCalculator {
//     String tk = "Tk";
//     private static final double RATE_PER_HOUR = 50.0; 
//     private static final double RATE_ADDITIONAL_HOUR = 30.0;

    
//     public static double calculateFee(LocalDateTime entryTime, LocalDateTime exitTime) {
//         long totalMinutes = ChronoUnit.MINUTES.between(entryTime, exitTime);

        
//         if (totalMinutes < 5) {
//             return 0.0;
//         }

        
//         long totalHours = (long) Math.ceil(totalMinutes / 60.0);

//         if (totalHours <= 0) {
//             return 0.0;
//         }

//         double fee = 0.0;
//         if (totalHours >= 1) {
//             fee += RATE_PER_HOUR;
//             if (totalHours > 1) {
//                 fee += (totalHours - 1) * RATE_ADDITIONAL_HOUR;
//             }
//         }

//         return fee;
//     }
// }