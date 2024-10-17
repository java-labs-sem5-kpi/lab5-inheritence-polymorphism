package com.sergosoft.railwaymanager.train.route;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Route} class represents a train's route, which consists of a series of {@link RouteRecord}
 * objects that define the train's stops along the way, including its starting and ending stations.
 *
 * <p>The route is represented as a list of records, where each {@link RouteRecord} contains
 * information about the station, departure time, and arrival time.</p>
 */
public class Route extends ArrayList<RouteRecord> {

    /**
     * List containing the route's records, including departure and arrival points.
     */
    private List<RouteRecord> routeRecordList = new ArrayList<>();

    /**
     * Constructs a {@code Route} with the provided departure and arrival records.
     *
     * @param departureRecord the starting point of the route, must not be {@code null}.
     * @param arrivalRecord the endpoint of the route, must not be {@code null}.
     * @throws IllegalArgumentException if either {@code departureRecord} or {@code arrivalRecord} are {@code null}.
     */
    public Route(RouteRecord departureRecord, RouteRecord arrivalRecord) {
        if (departureRecord == null || arrivalRecord == null) {
            throw new IllegalArgumentException("Departure and arrival records must be not null.");
        }
        routeRecordList.add(departureRecord);
        routeRecordList.add(arrivalRecord);
    }

    /**
     * Constructs a {@code Route} with the provided list of route records.
     *
     * @param routeRecordList the list of {@link RouteRecord} objects that define the route.
     *                        Must contain at least a departure and an arrival record.
     * @throws IllegalArgumentException if the list is {@code null} or contains fewer than two records.
     */
    public Route(List<RouteRecord> routeRecordList) {
        if (routeRecordList == null) {
            throw new IllegalArgumentException("Route list cannot be null.");
        }
        if (routeRecordList.size() < 2) {
            throw new IllegalArgumentException("Route list must contain at least arrival and departure records.");
        }
        this.routeRecordList = routeRecordList;
    }

    /**
     * Returns the first {@link RouteRecord} of the route, representing the departure station.
     *
     * @return the departure {@code RouteRecord}.
     */
    public RouteRecord getStart() {
        return routeRecordList.get(0);
    }

    /**
     * Returns the last {@link RouteRecord} of the route, representing the arrival station.
     *
     * @return the arrival {@code RouteRecord}.
     */
    public RouteRecord getEnd() {
        return routeRecordList.get(routeRecordList.size() - 1);
    }
}
