package com.sergosoft.railwaymanager.train;

import java.util.ArrayList;
import java.util.List;

import com.sergosoft.railwaymanager.railwaycar.RailwayCar;

public abstract class Train <T extends RailwayCar> {
    protected List<T> railwayCarsList;

    public Train() {
        railwayCarsList = new ArrayList<>();
    }

    public Train(List<T> railwayCars) {
        this.railwayCarsList = railwayCars;
    }

    public int getRailwayCarsAmount() {
        return railwayCarsList.size();
    }

    public void setRailwayCarsList(List<T> railwayCarsList) {
        this.railwayCarsList = railwayCarsList;
    }
}
