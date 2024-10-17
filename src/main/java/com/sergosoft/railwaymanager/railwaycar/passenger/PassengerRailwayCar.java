package com.sergosoft.railwaymanager.railwaycar.passenger;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.sergosoft.railwaymanager.railwaycar.RailwayCar;

public class PassengerRailwayCar extends RailwayCar {
    private Map<Integer, Seat> seatsMap = new HashMap<>();
    private ComfortType comfortType;

    public PassengerRailwayCar(int length, int width, int maxSpeed, int serviceLife, float maxTareWeight, ComfortType comfortType, Map<Integer, Seat> seatsMap) {
        super(length, width, maxSpeed, serviceLife, maxTareWeight);
        if(comfortType == null) {
            throw new IllegalArgumentException("ComfortType cannot be null.");
        }

        this.seatsMap = seatsMap;
        this.comfortType = comfortType;
    }

    public PassengerRailwayCar(int length, int width, int maxSpeed, int serviceLife, float maxTareWeight, int seatsAmount, ComfortType comfortType) {
        super(length, width, maxSpeed, serviceLife, maxTareWeight);
        if(comfortType == null) {
            throw new IllegalArgumentException("ComfortType cannot be null.");
        }

        for(int seatNumber = 0; seatNumber < seatsAmount; seatNumber++) {
            seatsMap.put(seatNumber + 1, new Seat());
        }
        this.comfortType = comfortType;
    }

    public int getMaxPassengersAmount() {
        return seatsMap.size();
    }

    public Set<Seat> getSeats() {
        return Set.copyOf(seatsMap.values());
    }

    public ComfortType getComfortType() {
        return comfortType;
    }

    public void setComfortType(ComfortType comfortType) {
        this.comfortType = comfortType;
    }
}
