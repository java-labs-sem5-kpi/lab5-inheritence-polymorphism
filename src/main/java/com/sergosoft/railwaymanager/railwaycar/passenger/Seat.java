package com.sergosoft.railwaymanager.railwaycar.passenger;

/**
 * The {@code Seat} class represents a seat in a passenger railway car.
 *
 * <p>This class maintains information about the seat's occupancy status and whether it contains luggage.</p>
 */
public class Seat {

    /**
     * Indicates whether the seat is currently occupied.
     */
    private boolean isBusy;

    /**
     * Indicates whether the seat contains luggage.
     */
    private boolean containsLuggage;

    /**
     * Default constructor for {@code Seat}, initializing a seat with default values.
     * By default, the seat is neither busy nor containing luggage.
     */
    public Seat() {}

    /**
     * Constructs a {@code Seat} with specified occupancy and luggage status.
     *
     * @param isBusy indicates whether the seat is currently occupied.
     * @param containsLuggage indicates whether the seat contains luggage.
     */
    public Seat(boolean isBusy, boolean containsLuggage) {
        this.isBusy = isBusy;
        this.containsLuggage = containsLuggage;
    }

    /**
     * Returns whether the seat contains luggage.
     *
     * @return {@code true} if the seat contains luggage, {@code false} otherwise.
     */
    public boolean containsLuggage() {
        return containsLuggage;
    }

    /**
     * Sets the luggage status for the seat.
     *
     * @param containsLuggage {@code true} if the seat should contain luggage, {@code false} otherwise.
     */
    public void setContainsLuggage(boolean containsLuggage) {
        this.containsLuggage = containsLuggage;
    }

    /**
     * Returns whether the seat is currently occupied.
     *
     * @return {@code true} if the seat is busy (occupied), {@code false} otherwise.
     */
    public boolean isBusy() {
        return isBusy;
    }

    /**
     * Sets the occupancy status for the seat.
     *
     * @param busy {@code true} if the seat should be marked as occupied, {@code false} otherwise.
     */
    public void setBusy(boolean busy) {
        isBusy = busy;
    }
}
