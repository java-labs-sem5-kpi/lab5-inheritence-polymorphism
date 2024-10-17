package com.sergosoft.railwaymanager.train.route;

import java.util.ArrayList;
import java.util.List;

public class Route extends ArrayList<RouteRecord> {
    private List<RouteRecord> routeRecordList = new ArrayList<>();

    public Route(RouteRecord departureRecord, RouteRecord arrivalRecord) {
        if(departureRecord == null || arrivalRecord == null) {
            throw new IllegalArgumentException("Departure and arrival records must be not null.");
        }
        routeRecordList.add(departureRecord);
        routeRecordList.add(arrivalRecord);
    }

    public Route(List<RouteRecord> routeRecordList) {
        if(routeRecordList == null) {
            throw new IllegalArgumentException("Route list cannot be null.");
        }
        if(routeRecordList.size() < 2) {
            throw new IllegalArgumentException("Rout list must contain at least arrival and departure records.");
        }
        this.routeRecordList = routeRecordList;
    }
}
