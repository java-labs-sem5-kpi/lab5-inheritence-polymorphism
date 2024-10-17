package com.sergosoft.railwaymanager.train.passenger;

import java.util.List;

import com.sergosoft.railwaymanager.railwaycar.passenger.PassengerRailwayCar;
import com.sergosoft.railwaymanager.train.Train;
import com.sergosoft.railwaymanager.train.route.Route;

/**
 * The {@code PassengerTrain} class represents a train specifically designed for transporting passengers.
 *
 * <p>It extends the {@link Train} class and includes additional information specific to passenger trains,
 * such as the train's name.</p>
 */
public class PassengerTrain extends Train<PassengerRailwayCar> {

    /**
     * The name of the passenger train.
     */
    private String name;

    /**
     * Constructs a {@code PassengerTrain} with the specified list of railway cars, train number, route, and name.
     *
     * @param railwayCarsList the list of {@link PassengerRailwayCar} objects that make up the train.
     * @param number the unique number assigned to the train.
     * @param route the route the train will follow, must not be {@code null}.
     * @param name the name of the passenger train, must not be {@code null} or empty.
     * @throws IllegalArgumentException if the {@code railwayCarsList} or {@code route} is {@code null}.
     */
    public PassengerTrain(List<PassengerRailwayCar> railwayCarsList, int number, Route route, String name) {
        super(railwayCarsList, number, route);
        this.name = name;
    }

    /**
     * Returns the name of the passenger train.
     *
     * @return the name of the train.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the passenger train.
     *
     * @param name the new name for the train, must not be {@code null} or empty.
     * @throws IllegalArgumentException if the provided name is {@code null} or empty.
     */
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Train name must not be null or empty.");
        }
        this.name = name;
    }
}
