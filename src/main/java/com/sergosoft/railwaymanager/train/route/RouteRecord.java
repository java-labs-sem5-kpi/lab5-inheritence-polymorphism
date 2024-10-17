package com.sergosoft.railwaymanager.train.route;

import java.time.LocalDateTime;

/**
 * The {@code RouteRecord} class represents a record of a train station stop, containing information
 * about the station name, departure time, and arrival time.
 *
 * <p>This record is used to define a station on the train's route, including the times when
 * the train arrives at or departs from the station.</p>
 *
 * @param stationName the name of the station, must not be {@code null} or empty.
 * @param departureTime the time when the train departs from the station, can be {@code null}.
 * @param arrivalTime the time when the train arrives at the station, can be {@code null}.
 *
 */
public record RouteRecord(String stationName, LocalDateTime departureTime, LocalDateTime arrivalTime) {

    /**
     * Constructs a {@code RouteRecord} and validates the input parameters.
     *
     * @throws IllegalArgumentException if the {@code stationName} is {@code null} or blank,
     *                                  if both {@code departureTime} and {@code arrivalTime} are {@code null},
     *                                  or if {@code departureTime} is after {@code arrivalTime}.
     */
    public RouteRecord {
        if (stationName == null || stationName.isBlank()) {
            throw new IllegalArgumentException("Station name cannot be null or empty.");
        }
        if (departureTime == null && arrivalTime == null) {
            throw new IllegalArgumentException("Departure or arrival time must be not null.");
        }
        if (departureTime != null && arrivalTime != null && departureTime.isAfter(arrivalTime)) {
            throw new IllegalArgumentException("Departure time cannot be after arrival time.");
        }
    }
}
