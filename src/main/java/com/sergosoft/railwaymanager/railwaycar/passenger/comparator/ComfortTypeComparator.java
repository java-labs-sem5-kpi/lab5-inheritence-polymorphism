package com.sergosoft.railwaymanager.railwaycar.passenger.comparator;

import java.util.Comparator;

import com.sergosoft.railwaymanager.railwaycar.passenger.PassengerRailwayCar;

public class ComfortTypeComparator implements Comparator<PassengerRailwayCar> {
    @Override
    public int compare(PassengerRailwayCar o1, PassengerRailwayCar o2) {
        return o1.getComfortType().compareTo(o2.getComfortType());
    }
}
