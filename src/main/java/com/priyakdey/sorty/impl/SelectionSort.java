package com.priyakdey.sorty.impl;

import com.priyakdey.sorty.Sort;

/**
 * Implementation of the Selection Sort.
 *
 * <p>
 * Selection Sort is a simple, in-place sorting algorithm that sorts an array by repeatedly finding
 * the minimum element from the unsorted part of the array and swapping it with the first element
 * in the unsorted part of the array. This process is repeated until the array is sorted.
 * The name Selection Sort, is probably because in each iteration, we select an element,
 * and place it at the head of the unsorted range of elements.
 * </p>
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
 * <p>Learn more about Insertion Sort on its <a href="https://en.wikipedia.org/wiki/Selection_sort">Wikipedia page</a>.</p>
 *
 * @param <T> the type of elements in the array. Must implement {@link Comparable}.
 * @author Priyak Dey
 */
public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] elements) {
        if (elements.length == 1) {
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            T min = elements[i];
            int indexOfMin = i;
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j].compareTo(min) < 0) {
                    min = elements[j];
                    indexOfMin = j;
                }
            }
            elements[indexOfMin] = elements[i];
            elements[i] = min;
        }
    }
}
