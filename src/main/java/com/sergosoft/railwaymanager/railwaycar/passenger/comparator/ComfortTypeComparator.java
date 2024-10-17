package com.sergosoft.railwaymanager.railwaycar.passenger.comparator;

import java.util.Comparator;

import com.sergosoft.railwaymanager.railwaycar.passenger.ComfortType;
import com.sergosoft.railwaymanager.railwaycar.passenger.PassengerRailwayCar;

/**
 * The {@code ComfortTypeComparator} class implements the {@link Comparator} interface to provide
 * a comparison mechanism for {@link PassengerRailwayCar} objects based on their comfort type.
 *
 * <p>This comparator orders passenger railway cars by their {@link ComfortType}, allowing
 * sorting of cars based on their level of comfort.</p>
 */
public class ComfortTypeComparator implements Comparator<PassengerRailwayCar> {

    /**
     * Compares two {@link PassengerRailwayCar} objects based on their comfort types.
     *
     * <p>This method returns a negative integer, zero, or a positive integer as the first
     * argument is less than, equal to, or greater than the second.</p>
     *
     * @param o1 the first passenger railway car to be compared
     * @param o2 the second passenger railway car to be compared
     * @return a negative integer, zero, or a positive integer as the comfort type of the
     *         first railway car is less than, equal to, or greater than the comfort type
     *         of the second railway car
     */
    @Override
    public int compare(PassengerRailwayCar o1, PassengerRailwayCar o2) {
        return o1.getComfortType().compareTo(o2.getComfortType());
    }
}
