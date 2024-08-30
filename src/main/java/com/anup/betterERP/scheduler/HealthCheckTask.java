package com.anup.betterERP.scheduler;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;
import java.util.TimeZone;

@Component
public class HealthCheckTask {

    private final RestTemplate restTemplate = new RestTemplate();

//    @Scheduled(fixedRate = 840000) // Task runs every 13 minutes (13 * 60 * 1000 ms)
//    public void sendHealthCheckRequest() {
//        // Set the time zone to IST
//        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
//
//        LocalTime currentTime = LocalTime.now();
//
//        // Define the start and end times
//        LocalTime startTime = LocalTime.of(5, 0);  // 4 AM
//        LocalTime endTime = LocalTime.of(2, 0);    // 2 AM (next day)
//
//        // Check if the current time is within the desired range
//        if (currentTime.isAfter(startTime) || currentTime.isBefore(endTime)) {
//            // Send the GET request
//            String url = "https://bettererp.onrender.com/api/health";
//            try {
//                ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
////                System.out.println("Health check response: " + response.getStatusCode());
//            } catch (Exception e) {
//                System.err.println("Failed to send health check request: " + e.getMessage());
//            }
//        }
//    }

    @Scheduled(fixedRate = 840000)
    public void sendHealthCheckRequest() {
        String url = "https://bettererp.onrender.com/api/health";
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        } catch (Exception e) {
            System.err.println("Failed to send health check request: " + e.getMessage());
        }
    }
}