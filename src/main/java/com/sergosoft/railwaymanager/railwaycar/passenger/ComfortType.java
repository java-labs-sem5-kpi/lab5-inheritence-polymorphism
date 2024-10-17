package com.sergosoft.railwaymanager.railwaycar.passenger;

/**
 * The {@code ComfortType} enum represents the different levels of comfort available for
 * passenger railway cars.
 *
 * <p>This enum provides a way to categorize passenger railway cars based on their seating
 * arrangements and amenities. Each constant represents a specific type of comfort.</p>
 */
public enum ComfortType {
    /**
     * Represents the luxury class with the highest level of comfort and amenities.
     */
    LUX,

    /**
     * Represents a coupe class, typically featuring enclosed compartments for a small number of passengers.
     */
    COUPE,

    /**
     * Represents the platzkart class, a more economical option with open compartments.
     */
    PLATSKART,

    /**
     * Represents the sitting first class, providing comfortable seating arrangements.
     */
    SITTING_FIRST_CLASS,

    /**
     * Represents the sitting second class, offering basic seating arrangements at a lower price point.
     */
    SITTING_SECOND_CLASS
}
