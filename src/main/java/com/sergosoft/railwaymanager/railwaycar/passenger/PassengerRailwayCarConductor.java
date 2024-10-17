package com.sergosoft.railwaymanager.railwaycar.passenger;

import com.sergosoft.railwaymanager.railwaycar.RailwayCarConductor;

/**
 * The {@code PassengerRailwayCarConductor} class is responsible for managing the operations
 * related to a {@code PassengerRailwayCar}, including counting passengers and luggage.
 *
 * <p>This class extends the {@code RailwayCarConductor} class, providing specialized functionality
 * for passenger railway cars.</p>
 */
public class PassengerRailwayCarConductor extends RailwayCarConductor<PassengerRailwayCar> {

    /**
     * Constructs a {@code PassengerRailwayCarConductor} for a specified passenger railway car.
     *
     * @param railwayCar the {@code PassengerRailwayCar} managed by this conductor.
     * @throws IllegalArgumentException if the provided railway car is {@code null}.
     */
    public PassengerRailwayCarConductor(PassengerRailwayCar railwayCar) {
        super(railwayCar);
    }

    /**
     * Counts the number of passengers currently occupying seats in the managed railway car.
     *
     * @return the total number of occupied seats (passengers) in the railway car.
     */
    public int countPassengers() {
        int passengersAmount = 0;
        for (Seat seat : railwayCar.getSeats()) {
            if (seat.isBusy()) {
                passengersAmount++;
            }
        }
        return passengersAmount;
    }

    /**
     * Counts the number of luggage items currently placed in occupied seats of the managed railway car.
     *
     * @return the total number of luggage items in the railway car.
     */
    public int countLuggage() {
        int luggageAmount = 0;
        for (Seat seat : railwayCar.getSeats()) {
            if (seat.containsLuggage()) {
                luggageAmount++;
            }
        }
        return luggageAmount;
    }
}
