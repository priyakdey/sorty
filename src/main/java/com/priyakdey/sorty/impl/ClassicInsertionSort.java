package com.priyakdey.sorty.impl;

import com.priyakdey.sorty.Sort;

/**
 * Implementation of the Classic Insertion Sort algorithm.
 *
 * <p>This sorting algorithm iteratively builds a sorted sub-array
 * from the left to the right. In each iteration, it removes an
 * element from the unsorted sub-array and compares it to the elements
 * in the sorted sub-array to find its correct insertion position. Once
 * the position is found, the element is inserted, and the elements
 * to its right are shifted.</p>
 *
 * <h3>Time Complexity:</h3>
 * <ul>
 *     <li>Worst-case: O(n<sup>2</sup>)</li>
 *     <li>Best-case: O(n)</li>
 *     <li>Average-case: O(n<sup>2</sup>)</li>
 * </ul>
 *
 * <h3>Space Complexity:</h3>
 * <p>This algorithm sorts in place and thus requires O(1)
 * additional space.</p>
 *
 * <p>Learn more about Insertion Sort on its <a href="https://en.wikipedia.org/wiki/Insertion_sort">Wikipedia page</a>.</p>
 *
 * @param <T> the type of elements in the array. Must implement {@link Comparable}.
 * @author Priyak Dey
 */
public class ClassicInsertionSort<T extends Comparable<T>> implements Sort<T> {


    @Override
    public void sort(T[] elements) {
        if (elements.length == 1) {
            return;
        }

        for (int i = 1; i < elements.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (elements[j].compareTo(elements[j - 1]) < 0) {
                    swap(elements, j, j - 1);
                } else {
                    break;      // elements in the left half of current position are already sorted
                }
            }
        }

    }

    private void swap(T[] elements, int i, int j) {
        T temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}
