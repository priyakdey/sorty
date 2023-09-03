package com.priyakdey.sorty.impl;

import com.priyakdey.sorty.Sort;

/**
 * One of the sorting strategies, Insertion Sort is a basic but less efficient sorting algorithm.
 * <p>
 * This implementation is going to use binary search to find insertion position.
 * <p>
 * For shifting elements, it is going to use {@link System#arraycopy} which being a native call,
 * should be faster than shifting elements using a for loop.
 * <p>
 * The reason for creating this class is to benchmark and see how in real words, such decisions
 * make differences. Since {@link System#arraycopy} should use
 * <a href="https://man7.org/linux/man-pages/man3/memcpy.3.html">memcpy<a/>
 * or <a href="https://man7.org/linux/man-pages/man3/memmove.3.html">memmove<a/> which should be faster.
 *
 * @author Priyak Dey
 */
public class BinarySearchInsertionSort<T extends Comparable<T>> implements Sort<T> {


    @Override
    public void sort(T[] elements) {
        if (elements.length == 1) {
            return;
        }

        // Step 1. Iterate from 1...n-1
        // Step 2. if elements[i] < elements[i - 1], find insert position of elements[i] in range of [0, i - 1]
        // Step 3: Shift elements in range of  [insert, i - 1] to [insert + 1, i]
        // Step 4: insert element in insert position

        for (int i = 1; i < elements.length; i++) {
            T element = elements[i];
            if (element.compareTo(elements[i - 1]) < 0) {
                int insertAt = findInsertIndex(elements, 0, i - 1, element);

                // copy elements from [insertAt, i - 1] to [insertAt + 1, i]
                int length = i - 1 - insertAt + 1;
                // @TODO(priyakdey) - check how the native implementation is.
                System.arraycopy(elements, insertAt, elements, insertAt + 1, length);

                // insert element to insertAt position
                elements[insertAt] = element;
            }
        }
    }

    /**
     * Find the insert index of element in the array elements, within the range of left and right,
     * both inclusive.
     *
     * @param elements T[]
     * @param left     the left bound of the range
     * @param right    the right bound of the range
     * @param element  the element to insert
     * @return int insert position
     */
    private int findInsertIndex(T[] elements, int left, int right, T element) {
        if (element.compareTo(elements[left]) <= 0) {
            return left;
        }

        int insertAt = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (elements[mid].compareTo(element) == 0) {
                insertAt = mid;
                break;
            } else if (elements[mid].compareTo(element) < 0) {
                left = mid + 1;
            } else {
                insertAt = mid;
                right = mid - 1;
            }
        }

        return insertAt;
    }
}
