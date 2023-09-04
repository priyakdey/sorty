package com.priyakdey.sorty.impl;

import com.priyakdey.sorty.Sort;

/**
 * Implementation of the Insertion Sort algorithm using Binary Search.
 *
 * <p>This variation improves upon the Classic Insertion Sort by using
 * Binary Search to find the correct insertion position, thus potentially
 * reducing the number of comparisons. Additionally, it uses
 * {@link System#arraycopy} for shifting elements, which is expected to
 * be more efficient as it likely utilizes native system calls such as
 * <a href="https://man7.org/linux/man-pages/man3/memcpy.3.html">memcpy</a> or
 * <a href="https://man7.org/linux/man-pages/man3/memmove.3.html">memmove</a>.</p>
 *
 * <h3>Time Complexity:</h3>
 * <ul>
 *     <li>Worst-case: O(n<sup>2</sup>) (Although fewer comparisons)</li>
 *     <li>Best-case: O(n)</li>
 *     <li>Average-case: O(n<sup>2</sup>) </li>
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
     * Finds the insertion index for a given element in a sub-array defined by left and right bounds.
     * The sub-array is assumed to be sorted in ascending order. This method uses binary search to
     * efficiently locate the insertion index.
     *
     * <p>The method returns the index at which the given element should be inserted to maintain
     * the sorted order of the sub-array. If multiple elements in the sub-array are equal to the
     * given element, the index of any one  of the occurrence is returned.</p>
     *
     * @param elements The array of elements in which to find the insertion index. The elements
     *                 must implement the {@link Comparable} interface.
     * @param left     The leftmost index of the sub-array to search, inclusive.
     * @param right    The rightmost index of the sub-array to search, inclusive.
     * @param element  The element for which to find the insertion index.
     * @return The index at which the element should be inserted to maintain the sorted
     * order of the sub-array.
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
