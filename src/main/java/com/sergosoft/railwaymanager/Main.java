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
        // Initialize Seats for the railway cars
        Map<Integer, Seat> seatsMap = new HashMap<>();

        // Adding 20 regular seats
        for(int i = 1; i <= 20; i++) {
            seatsMap.put(i, new Seat());
        }

        // Adding 20 VIP seats
        for(int i = 21; i <= 40; i++) {
            seatsMap.put(i, new Seat(true, true));
        }

        // Adding 10 booked seats
        for(int i = 41; i <= 50; i++) {
            seatsMap.put(i, new Seat(true, false));
        }

        // Adding 7 Coupe cars
        List<PassengerRailwayCar> passengerRailwayCarList = new ArrayList<>();
        for(int i = 1; i <= 7; i++) {
            PassengerRailwayCar coupeCar = new PassengerRailwayCar(10000, 3000, 160, 30, 3000, ComfortType.COUPE, seatsMap);
            passengerRailwayCarList.add(coupeCar);
        }

        // Adding 3 Luxury cars (empty seats map for simplicity)
        for(int i = 1; i <= 3; i++) {
            PassengerRailwayCar luxCar = new PassengerRailwayCar(10000, 3000, 160, 30, 3000, ComfortType.LUX, new HashMap<>());
            passengerRailwayCarList.add(luxCar);
        }

        // Adding 3 Platskart cars
        for(int i = 1; i <= 3; i++) {
            PassengerRailwayCar platskartCar = new PassengerRailwayCar(10000, 3000, 160, 30, 3000, ComfortType.PLATSKART, Map.copyOf(seatsMap));
            passengerRailwayCarList.add(platskartCar);
        }

        // Define the train's route (from Kyiv to Kharkiv)
        Route route = new Route(
                new RouteRecord("Kyiv", LocalDateTime.of(2024, 10, 17, 22, 5), null),
                new RouteRecord("Kharkiv", null, LocalDateTime.of(2024, 10, 18, 6, 0))
        );

        // Create the PassengerTrain and TrainSupervisor
        PassengerTrain passengerTrain = new PassengerTrain(passengerRailwayCarList, 64, route, "Oberig");
        PassengerTrainSupervisor trainSupervisor = new PassengerTrainSupervisor(passengerTrain);

        // Display key details of the train and its status

        System.out.println("===== Train Information =====");
        System.out.printf("Train Name: %s\n", passengerTrain.getName());
        System.out.printf("Route: %s to %s\n", route.getStart().stationName(), route.getEnd().stationName());
        System.out.printf("Departure: %s, Arrival: %s\n\n", route.getStart().departureTime(), route.getEnd().arrivalTime());

        System.out.println("===== Passengers and Capacity =====");
        System.out.printf("Total passengers: %d / %d\n", trainSupervisor.getPassengersAmount(), trainSupervisor.getGeneralPassengersCapacity());
        System.out.printf("Luggage places busy: %d / %d\n\n", trainSupervisor.getLuggageAmount(), trainSupervisor.getGeneralPassengersCapacity());

        // Show railway cars
        System.out.println("===== Railway Cars =====");
        trainSupervisor.getRailwayCarsList().forEach(System.out::println);

        // Show railway cars sorted by comfort type
        System.out.println("\n===== Railway Cars Sorted by Comfort Type =====");
        trainSupervisor.getSortedRailwayCarListByComfortType()
                .forEach(System.out::println);

        // Filter and display cars with passengers in the range of 22 to 30
        System.out.println("\n===== Railway Cars with Passengers Between 22 and 30 =====");
        trainSupervisor.getWagonsByPassengerAmountBetween(22, 30)
                .forEach(System.out::println);
    }
}