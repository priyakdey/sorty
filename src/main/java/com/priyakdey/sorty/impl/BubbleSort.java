package com.priyakdey.sorty.impl;

import com.priyakdey.sorty.Sort;

/**
 * An implementation of the Bubble Sort algorithm.
 *
 * <p>
 * Bubble Sort is a simple sorting algorithm that repeatedly iterates through the list,
 * compares adjacent elements and swaps them if they are in the wrong order. The algorithm
 * continues this process until no more swaps are needed, indicating that the list is sorted.
 * </p>
 *
 * <h3>Time Complexity:</h3>
 * <ul>
 *     <li>Worst-case: O(n<sup>2</sup>)</li>
 *     <li>Best-case: O(n)</li>
 *     <li>Average-case: O(n<sup>2</sup>) </li>
 * </ul>
 *
 * <h3>Space Complexity:</h3>
 * <p>This algorithm sorts in place and thus requires O(1)
 * additional space.</p>
 *
 * <p>Learn more about Bubble Sort on its <a href="https://en.wikipedia.org/wiki/Bubble_sort">Wikipedia page</a>.</p>
 *
 * @param <T> The type of elements to be sorted. The type must implement the {@link Comparable} interface.
 * @author Priyak Dey
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] elements) {
        if (elements.length == 1) {
            return;
        }

        for (int i = 0; i < elements.length - 1; i++) {
            for (int j = 0; j < elements.length - 1 - i; j++) {
                if (elements[j].compareTo(elements[j + 1]) > 0) {
                    swap(elements, j, j + 1);
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
