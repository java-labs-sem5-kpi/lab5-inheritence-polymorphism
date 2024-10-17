package com.sergosoft.railwaymanager.railwaycar.passenger;

public class Seat {
    private boolean isBusy;
    private boolean containsLuggage;

    public Seat() {}

    public Seat(boolean isBusy, boolean containsLuggage) {
        this.isBusy = isBusy;
        this.containsLuggage = containsLuggage;
    }

    public boolean containsLuggage() {
        return containsLuggage;
    }

    public void setContainsLuggage(boolean containsLuggage) {
        this.containsLuggage = containsLuggage;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }
}
