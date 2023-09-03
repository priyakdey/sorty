package com.priyakdey.sorty;

/**
 * A common interface for all sorting strategies.
 *
 * @author Priyak Dey
 */
public interface Sort<T extends Comparable<T>> {

    /**
     * Method which sorts the array of elements, in place.
     *
     * @param elements T[]
     */
    void sort(T[] elements);

}
