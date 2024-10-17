package com.sergosoft.railwaymanager.train.passenger;

import com.sergosoft.railwaymanager.railwaycar.passenger.PassengerRailwayCar;
import com.sergosoft.railwaymanager.railwaycar.passenger.Seat;
import com.sergosoft.railwaymanager.train.TrainSupervisor;

public class PassengerTrainSupervisor extends TrainSupervisor<PassengerTrain> {
    public PassengerTrainSupervisor(PassengerTrain train) {
        super(train);
    }

    public long getPassengersAmount() {
        long passengersAmount = 0;
        for(PassengerRailwayCar railwayCar : train.getRailwayCarsList()) {
            passengersAmount += railwayCar.getSeats().stream().filter(Seat::isBusy).count();
        }
        return passengersAmount;
    }

    public long getLuggageAmount() {
        long luggageAmount = 0;
        for(PassengerRailwayCar railwayCar : train.getRailwayCarsList()) {
            luggageAmount += railwayCar.getSeats().stream().filter(Seat::containsLuggage).count();
        }
        return luggageAmount;
    }
}
