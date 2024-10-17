package com.sergosoft.railwaymanager.train.route;

import java.time.LocalDateTime;

public record RouteRecord(String stationName, LocalDateTime departureTime, LocalDateTime arrivalTime) {
    public RouteRecord {
        if(stationName == null || stationName.isBlank()) {
            throw new IllegalArgumentException("Station name cannot be null or empty.");
        }
        if(departureTime == null && arrivalTime == null) {
            throw new IllegalArgumentException("Departure or arrival time must be not null.");
        }
        if(departureTime != null && arrivalTime != null && departureTime.isAfter(arrivalTime)) {
            throw new IllegalArgumentException("Departure time cannot be after arrival time.");
        }
    }
}
