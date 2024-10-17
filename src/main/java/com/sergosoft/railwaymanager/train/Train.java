package com.sergosoft.railwaymanager.train;

import java.util.List;

import com.sergosoft.railwaymanager.railwaycar.RailwayCar;
import com.sergosoft.railwaymanager.train.route.Route;

/**
 * Abstract class {@code Train} represents a generic train consisting of railway cars,
 * identified by a train number and assigned to a specific route.
 *
 * @param <C> the type of {@link RailwayCar} contained in the train.
 */
public abstract class Train<C extends RailwayCar> {

    /**
     * The list of railway cars that the train consists of.
     */
    protected List<C> railwayCarsList;

    /**
     * The unique number identifying the train.
     */
    private int number;

    /**
     * The route that the train follows.
     */
    private Route route;

    /**
     * Constructs a {@code Train} with a list of railway cars, a unique train number, and a route.
     *
     * @param railwayCarsList the list of railway cars, must not be {@code null}.
     * @param number the unique number identifying the train.
     * @param route the route assigned to the train, must not be {@code null}.
     * @throws IllegalArgumentException if {@code railwayCarsList} or {@code route} are {@code null}.
     */
    public Train(List<C> railwayCarsList, int number, Route route) {
        if (railwayCarsList == null || route == null) {
            throw new IllegalArgumentException("CarList and Route cannot be null.");
        }
        this.railwayCarsList = railwayCarsList;
        this.number = number;
        this.route = route;
    }

    /**
     * Returns an unmodifiable copy of the list of railway cars in the train.
     *
     * @return an unmodifiable list of railway cars.
     */
    public List<C> getRailwayCarsList() {
        return List.copyOf(railwayCarsList);
    }

    /**
     * Sets a new list of railway cars for the train.
     *
     * @param railwayCarsList the new list of railway cars.
     */
    public void setRailwayCarsList(List<C> railwayCarsList) {
        this.railwayCarsList = railwayCarsList;
    }

    /**
     * Returns the train's unique number.
     *
     * @return the train number.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets a new unique number for the train.
     *
     * @param number the new train number.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Returns the route that the train follows.
     *
     * @return the train's route.
     */
    public Route getRoute() {
        return route;
    }

    /**
     * Sets a new route for the train.
     *
     * @param route the new route for the train.
     */
    public void setRoute(Route route) {
        this.route = route;
    }
}
