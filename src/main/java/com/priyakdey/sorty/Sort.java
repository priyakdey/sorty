package com.priyakdey.sorty;

/**
 * The {@code Sort} interface defines a contract for sorting algorithms. Implementations of
 * this interface should provide a sorting mechanism for an array of elements that implement
 * the {@link Comparable} interface.
 *
 * <p>Classes that implement this interface are expected to sort the array in-place,
 * meaning they should not return a new array but should instead sort the array passed
 * as a parameter.</p>
 *
 * <h2>Usage Example:</h2>
 * <pre>
 * {@code
 * Sort<Integer> sortAlgorithm = new SomeSortImplementation<>();
 * Integer[] elements = {3, 1, 4, 1, 5, 9, 2, 6, 5};
 * sortAlgorithm.sort(elements);
 * }
 * </pre>
 *
 * @param <T> The type of elements that this sorting algorithm can sort. Must implement
 *            {@link Comparable}.
 * @author Priyak Dey
 */
public interface Sort<T extends Comparable<T>> {

    /**
     * Sorts an array of elements in-place. The elements must implement the {@link Comparable}
     * interface. After the method returns, the array is guaranteed to be sorted in ascending order.
     *
     * <p><strong>Note:</strong> Implementations should sort the array in-place and should not
     * create a new array.</p>
     *
     * @param elements The array of elements to be sorted. Must be of a type that implements
     *                 {@link Comparable}.
     */
    void sort(T[] elements);
}
