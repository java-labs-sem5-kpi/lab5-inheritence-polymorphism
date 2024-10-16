package com.sergosoft.railwaymanager;

import com.sergosoft.railwaymanager.railwaycar.passenger.PassengerRailwayCar;
import com.sergosoft.railwaymanager.train.PassengerTrain;
import com.sergosoft.railwaymanager.train.Train;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PassengerRailwayCar> passengerRailwayCars = new ArrayList<>();
        passengerRailwayCars.add(new PassengerRailwayCar());

        Train<PassengerRailwayCar> passengerTrain = new PassengerTrain();
    }
}