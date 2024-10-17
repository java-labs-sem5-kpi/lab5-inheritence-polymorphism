package com.sergosoft.railwaymanager.railwaycar;

/**
 * The {@code RailwayCarConductor} class serves as an abstract base class for conducting specific types of railway cars.
 *
 * <p>This class holds a reference to a {@link RailwayCar} and ensures that the car is not null during construction.</p>
 *
 * @param <C> the type of {@link RailwayCar} that this conductor manages.
 */
public abstract class RailwayCarConductor<C extends RailwayCar> {

    /**
     * The railway car managed by this conductor.
     */
    protected C railwayCar;

    /**
     * Constructs a {@code RailwayCarConductor} for the specified railway car.
     *
     * @param railwayCar the railway car to be managed, must not be {@code null}.
     * @throws IllegalArgumentException if the provided railway car is {@code null}.
     */
    public RailwayCarConductor(C railwayCar) {
        if (railwayCar == null) {
            throw new IllegalArgumentException("RailwayCar cannot be null.");
        }
        this.railwayCar = railwayCar;
    }
}
