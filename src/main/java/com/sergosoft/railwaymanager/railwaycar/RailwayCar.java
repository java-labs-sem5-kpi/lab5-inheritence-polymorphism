package com.sergosoft.railwaymanager.railwaycar;

/**
 * The {@code RailwayCar} class represents a generic railway car with common attributes.
 *
 * <p>This class serves as a base class for specific types of railway cars, providing
 * properties such as dimensions, maximum speed, service life, and tare weight.</p>
 */
public abstract class RailwayCar {

    /**
     * The length of the railway car in meters.
     */
    private int length;

    /**
     * The width of the railway car in meters.
     */
    private int width;

    /**
     * The maximum speed of the railway car in kilometers per hour.
     */
    private int maxSpeed;

    /**
     * The service life of the railway car in years.
     */
    private int serviceLife;

    /**
     * The maximum tare weight of the railway car in kilograms.
     */
    private float maxTareWeight;

    /**
     * Constructs a {@code RailwayCar} with specified dimensions, maximum speed,
     * service life, and maximum tare weight.
     *
     * @param length the length of the railway car in meters.
     * @param width the width of the railway car in meters.
     * @param maxSpeed the maximum speed of the railway car in kilometers per hour.
     * @param serviceLife the service life of the railway car in years.
     * @param maxTareWeight the maximum tare weight of the railway car in kilograms.
     */
    public RailwayCar(int length, int width, int maxSpeed, int serviceLife, float maxTareWeight) {
        this.length = length;
        this.width = width;
        this.maxSpeed = maxSpeed;
        this.serviceLife = serviceLife;
        this.maxTareWeight = maxTareWeight;
    }

    /**
     * Returns the length of the railway car.
     *
     * @return the length in meters.
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the length of the railway car.
     *
     * @param length the new length in meters.
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Returns the width of the railway car.
     *
     * @return the width in meters.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width of the railway car.
     *
     * @param width the new width in meters.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Returns the maximum speed of the railway car.
     *
     * @return the maximum speed in kilometers per hour.
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Sets the maximum speed of the railway car.
     *
     * @param maxSpeed the new maximum speed in kilometers per hour.
     */
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * Returns the service life of the railway car.
     *
     * @return the service life in years.
     */
    public int getServiceLife() {
        return serviceLife;
    }

    /**
     * Sets the service life of the railway car.
     *
     * @param serviceLife the new service life in years.
     */
    public void setServiceLife(int serviceLife) {
        this.serviceLife = serviceLife;
    }

    /**
     * Returns the maximum tare weight of the railway car.
     *
     * @return the maximum tare weight in kilograms.
     */
    public float getMaxTareWeight() {
        return maxTareWeight;
    }

    /**
     * Sets the maximum tare weight of the railway car.
     *
     * @param maxTareWeight the new maximum tare weight in kilograms.
     */
    public void setMaxTareWeight(float maxTareWeight) {
        this.maxTareWeight = maxTareWeight;
    }

    /**
     * Returns a string representation of the railway car, including its attributes.
     *
     * @return a string representation of the railway car.
     */
    @Override
    public String toString() {
        return "RailwayCar{" +
                "length=" + length +
                ", width=" + width +
                ", maxSpeed=" + maxSpeed +
                ", serviceLife=" + serviceLife +
                ", maxTareWeight=" + maxTareWeight +
                '}';
    }
}
