package com.sergosoft.railwaymanager;

import com.sergosoft.railwaymanager.railwaycar.passenger.ComfortType;
import com.sergosoft.railwaymanager.railwaycar.passenger.PassengerRailwayCar;
import com.sergosoft.railwaymanager.railwaycar.passenger.Seat;
import com.sergosoft.railwaymanager.train.passenger.PassengerTrain;
import com.sergosoft.railwaymanager.train.passenger.PassengerTrainSupervisor;
import com.sergosoft.railwaymanager.train.route.Route;
import com.sergosoft.railwaymanager.train.route.RouteRecord;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Seat> seatsMap = new HashMap<>();
        for(int i = 1; i <= 40; i++) {
            seatsMap.put(i, new Seat());
        }
        List<PassengerRailwayCar> passengerRailwayCarList = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            PassengerRailwayCar passengerRailwayCarCoupe = new PassengerRailwayCar(10000, 3000, 160, 30, 3000, ComfortType.COUPE, seatsMap);
            passengerRailwayCarList.add(passengerRailwayCarCoupe);
        }
        Route route = new Route(
                new RouteRecord("Kyiv", null, LocalDateTime.of(2024, 10, 17, 22, 5)),
                new RouteRecord("Kharkiv", LocalDateTime.of(2024, 10, 18, 6, 0), null)
        );
        PassengerTrain passengerTrain = new PassengerTrain(passengerRailwayCarList, 64, route, "Oberig");

        PassengerTrainSupervisor trainSupervisor = new PassengerTrainSupervisor(passengerTrain);
        System.out.printf("Passengers amount: %d; General passenger capacity: %d", trainSupervisor.getPassengersAmount(), trainSupervisor.getGeneralPassengersCapacity());
    }
}