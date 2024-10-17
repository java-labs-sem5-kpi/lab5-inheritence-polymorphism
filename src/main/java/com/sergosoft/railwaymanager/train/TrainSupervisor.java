package com.sergosoft.railwaymanager.train;

import com.sergosoft.railwaymanager.railwaycar.RailwayCar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Abstract class {@code TrainSupervisor} is responsible for managing and supervising a specific type of train.
 * It provides functionality to sort the train's railway cars using provided comparators and
 * retrieve the list of railway cars in the train.
 *
 * @param <T> the type of {@link Train} being supervised.
 * @param <C> the type of {@link RailwayCar} that the train contains.
 */
public abstract class TrainSupervisor<T extends Train<C>, C extends RailwayCar> {

    /**
     * The train instance being supervised.
     */
    protected T train;

    /**
     * Constructor for {@code TrainSupervisor}.
     * Initializes the supervisor with the provided train.
     *
     * @param train the train to be supervised, must not be {@code null}.
     * @throws IllegalArgumentException if the train is {@code null}.
     */
    public TrainSupervisor(T train) {
        if(train == null) {
            throw new IllegalArgumentException("Train must be not null.");
        }
        this.train = train;
    }

    /**
     * Sets a new train for this supervisor.
     *
     * @param train the new train to supervise, must not be {@code null}.
     */
    public void setTrain(T train) {
        this.train = train;
    }

    /**
     * Returns a sorted list of railway cars based on the provided comparator.
     *
     * @param comparator a {@link Comparator} to sort the railway cars.
     * @return a sorted list of railway cars.
     * @throws IllegalArgumentException if the comparator is {@code null}.
     */
    protected List<C> getSortedRailwayCarList(Comparator<C> comparator) {
        List<C> railwayCars = new ArrayList<>(List.copyOf(train.railwayCarsList));
        if(comparator == null) {
            throw new IllegalArgumentException("Comparator must be non null.");
        }
        railwayCars.sort(comparator);
        return railwayCars;
    }

    /**
     * Returns a sorted list of railway cars based on a list of comparators.
     * The list is sorted using each comparator sequentially.
     *
     * @param comparators a list of {@link Comparator} objects to sort the railway cars.
     * @return a sorted list of railway cars.
     * If the comparators list is empty, the original list is returned unsorted.
     */
    protected List<C> getSortedRailwayCarList(List<Comparator<C>> comparators) {
        List<C> railwayCars = new ArrayList<>(List.copyOf(train.railwayCarsList));
        if (comparators.isEmpty()) {
            return railwayCars;
        }
        for (Comparator<C> comparator : comparators) {
            railwayCars.sort(comparator);
        }
        return railwayCars;
    }

    /**
     * Returns an unmodifiable copy of the train's railway cars list.
     *
     * @return an unmodifiable list of the railway cars in the train.
     */
    public List<RailwayCar> getRailwayCarsList() {
        return List.copyOf(train.railwayCarsList);
    }
}
