package com.sergosoft.railwaymanager.railwaycar.passenger;

import com.sergosoft.railwaymanager.railwaycar.RailwayCar;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PassengerRailwayCar extends RailwayCar {
    private Map<Integer, Seat> seatsMap = new HashMap<>();

    public PassengerRailwayCar(int length, int width, int maxSpeed, int serviceLife, float maxTareWeight, Map<Integer, Seat> seatsMap) {
        super(length, width, maxSpeed, serviceLife, maxTareWeight);
        this.seatsMap = seatsMap;
    }

    public PassengerRailwayCar(int length, int width, int maxSpeed, int serviceLife, float maxTareWeight, int seatsAmount) {
        super(length, width, maxSpeed, serviceLife, maxTareWeight);
        for(int seatNumber = 0; seatNumber < seatsAmount; seatNumber++) {
            seatsMap.put(seatNumber + 1, new Seat());
        }
    }

    public Set<Seat> getSeats() {
        return Set.copyOf(seatsMap.values());
    }
}
