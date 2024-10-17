package com.sergosoft.railwaymanager.train.passenger;

import java.util.List;

import com.sergosoft.railwaymanager.railwaycar.passenger.PassengerRailwayCar;
import com.sergosoft.railwaymanager.train.Train;
import com.sergosoft.railwaymanager.train.route.Route;

public class PassengerTrain extends Train<PassengerRailwayCar> {
    private String name;

    public PassengerTrain(List<PassengerRailwayCar> railwayCarsList, int number, Route route, String name) {
        super(railwayCarsList, number, route);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
