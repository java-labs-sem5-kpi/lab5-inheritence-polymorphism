package com.sergosoft.railwaymanager.train.passenger;

import java.util.ArrayList;
import java.util.List;

import com.sergosoft.railwaymanager.railwaycar.passenger.PassengerRailwayCar;
import com.sergosoft.railwaymanager.railwaycar.passenger.PassengerRailwayCarConductor;
import com.sergosoft.railwaymanager.railwaycar.passenger.Seat;
import com.sergosoft.railwaymanager.railwaycar.passenger.comparator.ComfortTypeComparator;
import com.sergosoft.railwaymanager.train.TrainSupervisor;

/**
 * The {@code PassengerTrainSupervisor} class provides functionality to manage and monitor
 * a {@link PassengerTrain}, offering various operations related to passengers, luggage,
 * and railway cars.
 *
 * <p>It extends {@link TrainSupervisor} to work specifically with {@link PassengerTrain}
 * and {@link PassengerRailwayCar} objects.</p>
 */
public class PassengerTrainSupervisor extends TrainSupervisor<PassengerTrain, PassengerRailwayCar> {

    /**
     * Constructs a {@code PassengerTrainSupervisor} for the given {@link PassengerTrain}.
     *
     * @param train the passenger train to supervise, must not be {@code null}.
     * @throws IllegalArgumentException if the train is {@code null}.
     */
    public PassengerTrainSupervisor(PassengerTrain train) {
        super(train);
    }

    /**
     * Returns the total number of passengers currently on the train.
     *
     * <p>It sums the number of occupied seats in each {@link PassengerRailwayCar}.</p>
     *
     * @return the total count of passengers on the train.
     */
    public long getPassengersAmount() {
        long passengersAmount = 0;
        for (PassengerRailwayCar railwayCar : train.getRailwayCarsList()) {
            passengersAmount += railwayCar.getSeats().stream().filter(Seat::isBusy).count();
        }
        return passengersAmount;
    }

    /**
     * Returns the total number of luggage items currently stored on the train.
     *
     * <p>It sums the number of seats containing luggage in each {@link PassengerRailwayCar}.</p>
     *
     * @return the total count of luggage items on the train.
     */
    public long getLuggageAmount() {
        long luggageAmount = 0;
        for (PassengerRailwayCar railwayCar : train.getRailwayCarsList()) {
            luggageAmount += railwayCar.getSeats().stream().filter(Seat::containsLuggage).count();
        }
        return luggageAmount;
    }

    /**
     * Returns a list of passenger railway cars sorted by their comfort type.
     *
     * <p>The sorting is performed using the {@link ComfortTypeComparator}.</p>
     *
     * @return a sorted list of {@link PassengerRailwayCar} objects by comfort type.
     */
    public List<PassengerRailwayCar> getSortedRailwayCarListByComfortType() {
        return super.getSortedRailwayCarList(new ComfortTypeComparator());
    }

    /**
     * Returns the total passenger capacity of the train.
     *
     * <p>It sums the maximum passenger capacity of each {@link PassengerRailwayCar} on the train.</p>
     *
     * @return the total passenger capacity of the train.
     */
    public long getGeneralPassengersCapacity() {
        return train.getRailwayCarsList().stream().mapToInt(PassengerRailwayCar::getMaxPassengersAmount).sum();
    }

    /**
     * Returns a list of railway cars where the number of passengers is within the given range.
     *
     * <p>The method checks each car and includes it in the result if its number of passengers
     * is between the specified {@code minPassengers} and {@code maxPassengers} (inclusive).</p>
     *
     * @param minPassengers the minimum number of passengers to include a car.
     * @param maxPassengers the maximum number of passengers to include a car.
     * @return a list of {@link PassengerRailwayCar} objects within the specified passenger range.
     */
    public List<PassengerRailwayCar> getWagonsByPassengerAmountBetween(int minPassengers, int maxPassengers) {
        List<PassengerRailwayCar> passengerRailwayCars = new ArrayList<>();

        for (PassengerRailwayCar passengerRailwayCar : train.getRailwayCarsList()) {
            PassengerRailwayCarConductor conductor = new PassengerRailwayCarConductor(passengerRailwayCar);

            long passengerOnCar = conductor.countPassengers();
            if (passengerOnCar >= minPassengers && passengerOnCar <= maxPassengers) {
                passengerRailwayCars.add(passengerRailwayCar);
            }
        }

        return passengerRailwayCars;
    }
}
