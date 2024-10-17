package com.sergosoft.railwaymanager.railwaycar.passenger;

import com.sergosoft.railwaymanager.railwaycar.RailwayCarConductor;

public class PassengerRailwayCarConductor extends RailwayCarConductor<PassengerRailwayCar> {
    public PassengerRailwayCarConductor(PassengerRailwayCar railwayCar) {
        super(railwayCar);
    }

    public int countPassengers() {
        int passengersAmount = 0;
        for(Seat seat : railwayCar.getSeats()) {
            if(seat.isBusy()) {
                passengersAmount++;
            }
        }
        return passengersAmount;
    }

    public int countLuggage() {
        int luggageAmount = 0;
        for(Seat seat : railwayCar.getSeats()) {
            if(seat.containsLuggage()) {
                luggageAmount++;
            }
        }
        return luggageAmount;
    }
}
