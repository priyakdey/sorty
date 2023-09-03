package com.priyakdey.sorty.impl;

import com.priyakdey.sorty.Sort;

/**
 * One of the sorting strategies, Insertion Sort is a basic but less efficient sorting algorithm.
 * <p>
 * <h3>Idea behind Insertion Sort:</h3>
 * <a href="https://en.wikipedia.org/wiki/Insertion_sort">Learn More</a>
 * <p>
 * The algorithm assumes the left part of the array is sorted and starts iterating from position 1 (0-based index).
 * It compares the element at the current position with elements in the sorted part of the array to find its correct
 * insertion position. Once the position is found, the element is inserted in place, and elements to its right are shifted.
 * <p>
 * This algorithm has a time complexity of O(n<sup>2</sup>). But with smaller dataset, this is efficient
 * than its other quadratic counterparts. The best case scenario for this algorithm is O(n).
 * <p>
 * For space, extra space is not required and hence overall the space complexity is O(1).
 *
 * @author Priyak Dey
 */
public class ClassicInsertionSort<T extends Comparable<T>> implements Sort<T> {


    @Override
    public void sort(T[] elements) {
        if (elements.length == 1) return;

        for (int i = 1; i < elements.length; i++) {
            for (int j = i; j >= 1 ; j--) {
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
