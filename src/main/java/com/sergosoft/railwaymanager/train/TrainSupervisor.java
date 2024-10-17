package com.sergosoft.railwaymanager.train;

public abstract class TrainSupervisor <T extends Train> {
    protected T train;

    public TrainSupervisor(T train) {
        if(train == null) {
            throw new IllegalArgumentException("Train must be not null.");
        }
        this.train = train;
    }

    public void setTrain(T train) {
        this.train = train;
    }
}
