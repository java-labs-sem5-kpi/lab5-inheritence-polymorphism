package com.sergosoft.railwaymanager.train;

import com.sergosoft.railwaymanager.railwaycar.RailwayCar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class TrainSupervisor<T extends Train<C>, C extends RailwayCar> {
    protected T train;

    public TrainSupervisor(T train) {
        if(train == null) {
            throw new IllegalArgumentException("Train must be not null.");
        }
        this.train = train;
    }

    public void setTrain(T train) {
        this.train = train;
    }

    protected List<C> getSortedRailwayCarList(Comparator<C> comparator) {
        List<C> railwayCars = new ArrayList<>(List.copyOf(train.railwayCarsList));
        // if no comparators present
        if(comparator == null) {
            throw new IllegalArgumentException("Comparator must be non null.");
        }
        railwayCars.sort(comparator);
        return railwayCars;
    }

    protected List<C> getSortedRailwayCarList(List<Comparator<C>> comparators) {
        List<C> railwayCars = new ArrayList<>(List.copyOf(train.railwayCarsList));
        // if no comparators present
        if(comparators.isEmpty()) {
            return railwayCars;
        }
        for(Comparator<C> comparator : comparators) {
            railwayCars.sort(comparator);
        }
        return railwayCars;
    }
}
