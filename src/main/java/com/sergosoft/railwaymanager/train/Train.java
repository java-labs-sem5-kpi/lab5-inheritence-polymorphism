package com.sergosoft.railwaymanager.train;

import java.util.List;

import com.sergosoft.railwaymanager.railwaycar.RailwayCar;
import com.sergosoft.railwaymanager.train.route.Route;

public abstract class Train <C extends RailwayCar> {
    protected List<C> railwayCarsList;
    private int number;
    private Route route;

    public Train(List<C> railwayCarsList, int number, Route route) {
        if(railwayCarsList == null || route == null) {
            throw new IllegalArgumentException("CarList and Route cannot be null.");
        }
        this.railwayCarsList = railwayCarsList;
        this.number = number;
        this.route = route;
    }

    public List<RailwayCar> getRailwayCarsList() {
        return List.copyOf(railwayCarsList);
    }

    public void setRailwayCarsList(List<C> railwayCarsList) {
        this.railwayCarsList = railwayCarsList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
