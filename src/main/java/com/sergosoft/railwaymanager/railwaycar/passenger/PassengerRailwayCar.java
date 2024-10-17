package com.sergosoft.railwaymanager.railwaycar.passenger;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.sergosoft.railwaymanager.railwaycar.RailwayCar;

/**
 * The {@code PassengerRailwayCar} class represents a railway car designed to carry passengers.
 * It contains information about the seating arrangement and the comfort level of the car.
 *
 * <p>This class extends the {@code RailwayCar} class and adds functionality specific to passenger
 * railway cars, such as managing seats and comfort types.</p>
 */
public class PassengerRailwayCar extends RailwayCar {
    private Map<Integer, Seat> seatsMap = new HashMap<>();
    private ComfortType comfortType;

    /**
     * Constructs a {@code PassengerRailwayCar} with a specified seating arrangement and comfort type.
     *
     * @param length the length of the railway car.
     * @param width the width of the railway car.
     * @param maxSpeed the maximum speed of the railway car.
     * @param serviceLife the service life of the railway car in years.
     * @param maxTareWeight the maximum tare weight of the railway car.
     * @param comfortType the comfort type of the railway car (cannot be {@code null}).
     * @param seatsMap a map of seat numbers to their corresponding {@code Seat} objects.
     * @throws IllegalArgumentException if {@code comfortType} is {@code null}.
     */
    public PassengerRailwayCar(int length, int width, int maxSpeed, int serviceLife, float maxTareWeight, ComfortType comfortType, Map<Integer, Seat> seatsMap) {
        super(length, width, maxSpeed, serviceLife, maxTareWeight);
        if (comfortType == null) {
            throw new IllegalArgumentException("ComfortType cannot be null.");
        }

        this.seatsMap = seatsMap;
        this.comfortType = comfortType;
    }

    /**
     * Constructs a {@code PassengerRailwayCar} with a specified number of seats and comfort type.
     *
     * @param length the length of the railway car.
     * @param width the width of the railway car.
     * @param maxSpeed the maximum speed of the railway car.
     * @param serviceLife the service life of the railway car in years.
     * @param maxTareWeight the maximum tare weight of the railway car.
     * @param seatsAmount the total number of seats in the railway car.
     * @param comfortType the comfort type of the railway car (cannot be {@code null}).
     * @throws IllegalArgumentException if {@code comfortType} is {@code null}.
     */
    public PassengerRailwayCar(int length, int width, int maxSpeed, int serviceLife, float maxTareWeight, int seatsAmount, ComfortType comfortType) {
        super(length, width, maxSpeed, serviceLife, maxTareWeight);
        if (comfortType == null) {
            throw new IllegalArgumentException("ComfortType cannot be null.");
        }

        for (int seatNumber = 0; seatNumber < seatsAmount; seatNumber++) {
            seatsMap.put(seatNumber + 1, new Seat());
        }
        this.comfortType = comfortType;
    }

    /**
     * Returns the maximum number of passengers that can be accommodated in this railway car.
     *
     * @return the maximum number of passengers.
     */
    public int getMaxPassengersAmount() {
        return seatsMap.size();
    }

    /**
     * Returns a set of seats available in this passenger railway car.
     *
     * @return a set containing all {@code Seat} objects in this railway car.
     */
    public Set<Seat> getSeats() {
        return Set.copyOf(seatsMap.values());
    }

    /**
     * Returns the comfort type of this passenger railway car.
     *
     * @return the {@code ComfortType} of the railway car.
     */
    public ComfortType getComfortType() {
        return comfortType;
    }

    /**
     * Sets the comfort type of this passenger railway car.
     *
     * @param comfortType the new comfort type to be set (cannot be {@code null}).
     * @throws IllegalArgumentException if {@code comfortType} is {@code null}.
     */
    public void setComfortType(ComfortType comfortType) {
        if (comfortType == null) {
            throw new IllegalArgumentException("ComfortType cannot be null.");
        }
        this.comfortType = comfortType;
    }

    @Override
    public String toString() {
        return "PassengerRailwayCar{" +
                super.toString() +
                ", comfortType=" + comfortType +
                '}';
    }
}
