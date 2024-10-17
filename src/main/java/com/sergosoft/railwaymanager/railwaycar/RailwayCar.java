package com.sergosoft.railwaymanager.railwaycar;

public abstract class RailwayCar {
    private int length;
    private int width;
    private int maxSpeed;
    private int serviceLife;
    private float maxTareWeight;

    public RailwayCar(int length, int width, int maxSpeed, int serviceLife, float maxTareWeight) {
        this.length = length;
        this.width = width;
        this.maxSpeed = maxSpeed;
        this.serviceLife = serviceLife;
        this.maxTareWeight = maxTareWeight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getServiceLife() {
        return serviceLife;
    }

    public void setServiceLife(int serviceLife) {
        this.serviceLife = serviceLife;
    }

    public float getMaxTareWeight() {
        return maxTareWeight;
    }

    public void setMaxTareWeight(float maxTareWeight) {
        this.maxTareWeight = maxTareWeight;
    }
}
