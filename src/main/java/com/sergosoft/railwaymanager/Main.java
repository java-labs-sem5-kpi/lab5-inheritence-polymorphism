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
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Initialize Random for seat filling
        Random random = new Random();

        // Create the list for passenger railway cars
        List<PassengerRailwayCar> passengerRailwayCarList = new ArrayList<>();

        // Add different types of passenger cars
        addPassengerCars(passengerRailwayCarList, ComfortType.COUPE, 7, 20);
        addPassengerCars(passengerRailwayCarList, ComfortType.LUX, 3, 10);
        addPassengerCars(passengerRailwayCarList, ComfortType.PLATSKART, 3, 50);

        // Define the train's route (from Kyiv to Kharkiv)
        Route route = new Route(
                new RouteRecord("Kyiv", LocalDateTime.of(2024, 10, 17, 22, 5), null),
                new RouteRecord("Kharkiv", null, LocalDateTime.of(2024, 10, 18, 6, 0))
        );

        // Create the PassengerTrain and TrainSupervisor
        PassengerTrain passengerTrain = new PassengerTrain(passengerRailwayCarList, 64, route, "Oberig");
        PassengerTrainSupervisor trainSupervisor = new PassengerTrainSupervisor(passengerTrain);

        // Fill the cars with passengers randomly
        fillSeatsRandomly(passengerTrain.getRailwayCarsList(), random);

        // Display key details of the train and its status
        displayTrainInfo(passengerTrain, route, trainSupervisor);
    }

    private static void addPassengerCars(List<PassengerRailwayCar> passengerRailwayCarList, ComfortType comfortType, int count, int seatsAmount) {
        for (int i = 0; i < count; i++) {
            Map<Integer, Seat> seatsMap = new HashMap<>();
            for (int j = 1; j <= seatsAmount; j++) {
                seatsMap.put(j, new Seat());
            }
            PassengerRailwayCar car = new PassengerRailwayCar(10000, 3000, 160, 30, 3000, comfortType, seatsMap);
            passengerRailwayCarList.add(car);
        }
    }

    private static void fillSeatsRandomly(List<PassengerRailwayCar> railwayCars, Random random) {
        for (PassengerRailwayCar car : railwayCars) {
            for (Seat seat : car.getSeats()) {
                boolean isBusy = random.nextBoolean(); // Randomly assign whether the seat is busy
                boolean containsLuggage = isBusy && random.nextBoolean(); // If the seat is busy, there's a chance it contains luggage
                seat.setBusy(isBusy);
                seat.setContainsLuggage(containsLuggage);
            }
        }
    }

    private static void displayTrainInfo(PassengerTrain passengerTrain, Route route, PassengerTrainSupervisor trainSupervisor) {
        System.out.println("===== Train Information =====");
        System.out.printf("Train Name: %s\n", passengerTrain.getName());
        System.out.printf("Route: %s to %s\n", route.getStart().stationName(), route.getEnd().stationName());
        System.out.printf("Departure: %s, Arrival: %s\n\n", route.getStart().departureTime(), route.getEnd().arrivalTime());

        System.out.println("===== Passengers and Capacity =====");
        System.out.printf("Total passengers: %d / %d\n", trainSupervisor.getPassengersAmount(), trainSupervisor.getGeneralPassengersCapacity());
        System.out.printf("Luggage places busy: %d / %d\n\n", trainSupervisor.getLuggageAmount(), trainSupervisor.getGeneralPassengersCapacity());

        // Show railway cars with detailed information
        System.out.println("===== Railway Cars Details =====");
        for (PassengerRailwayCar car : passengerTrain.getRailwayCarsList()) {
            int passengersCount = 0;
            int luggageCount = 0;

            for (Seat seat : car.getSeats()) {
                if (seat.isBusy()) {
                    passengersCount++;
                    if (seat.containsLuggage()) {
                        luggageCount++;
                    }
                }
            }

            System.out.printf("Car Type: %s, Total Seats: %d, Passengers: %d, Luggage: %d\n",
                    car.getComfortType(), car.getMaxPassengersAmount(), passengersCount, luggageCount);
        }

        // Show railway cars sorted by comfort type
        System.out.println("\n===== Railway Cars Sorted by Comfort Type =====");
        trainSupervisor.getSortedRailwayCarListByComfortType()
                .forEach(System.out::println);

        // Filter and display cars with passengers in the range
        System.out.println("\n===== Railway Cars with Passengers Between 1 and 15 =====");
        trainSupervisor.getWagonsByPassengerAmountBetween(1, 15)
                .forEach(System.out::println);
    }
}
