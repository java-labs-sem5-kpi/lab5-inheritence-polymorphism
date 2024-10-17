package com.sergosoft.railwaymanager.railwaycar;

public abstract class RailwayCarConductor <C extends RailwayCar> {
    protected C railwayCar;

    public RailwayCarConductor(C railwayCar) {
        if(railwayCar == null) {
            throw new IllegalArgumentException("RailwayCar cannot be null.");
        }
        this.railwayCar = railwayCar;
    }
}
