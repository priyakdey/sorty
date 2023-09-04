package com.priyakdey.sorty.impl;

import com.priyakdey.sorty.Sort;
import java.lang.reflect.Array;

/**
 * Implementation of the Merge Sort algorithm.
 *
 * <p>This sorting algorithm is based on the idea of
 * <a href="https://en.wikipedia.org/wiki/Divide-and-conquer_algorithm">Divide and Conquer Algorithm</>
 * class of algorithms. Idea is simple - we have a huge complex task to complete, lets divide
 * it into simpler chunks of tasks, accomplish then and then finally after all sub-tasks are
 * over, it would lead to solution of the bigger problem.
 * </p>
 *
 * <p>In this case, the complex task is to sort an array. We should divide into smaller arrays,
 * sort them and rejoin the sub-arrays back to finally get a sorted array.
 * We generally divide the array into half and sort both halves and rejoin them back.
 * </p>
 *
 * <p>This implementation uses additional memory for merging the two smaller sorted arrays. While
 * there are in-place versions of Merge Sort, they are generally more complex and less straightforward.
 * Therefore, this implementation sticks to the classic approach for its readability and performance
 * characteristics.</p>
 *
 *
 * <h3>Time Complexity:</h3>
 * <ul>
 *     <li>Worst-case: O(n log n)</li>
 *     <li>Best-case: O(n log n))</li>
 *     <li>Average-case: O(n log n)</li>
 * </ul>
 *
 * <h3>Space Complexity:</h3>
 * <p>This algorithm does not sort in place and thus requires O(n)
 * additional space for the merging process.</p>
 *
 * <p>Learn more about Insertion Sort on its <a href="https://en.wikipedia.org/wiki/Insertion_sort">Wikipedia page</a>.</p>
 *
 * @param <T> the type of elements in the array. Must implement {@link Comparable}.
 * @author Priyak Dey
 */
public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] elements) {
        if (elements.length == 1) {
            return;
        }

        partition(elements, 0, elements.length - 1);
    }

    private void partition(T[] elements, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        partition(elements, left, mid);
        partition(elements, mid + 1, right);
        merge(elements, left, mid, right);
    }

    @SuppressWarnings("unchecked")
    private void merge(T[] elements, int left, int mid, int right) {
        int length = right - left + 1;

        // allocate new memory for merging the array
        T[] merged = (T[]) Array.newInstance(elements.getClass().getComponentType(), length);

        int curr1 = left, curr2 = mid + 1;
        int cursor = 0;

        while (curr1 <= mid && curr2 <= right) {
            if (elements[curr1].compareTo(elements[curr2]) <= 0) {
                merged[cursor++] = elements[curr1++];
            } else {
                merged[cursor++] = elements[curr2++];
            }
        }

        while (curr1 <= mid) {
            merged[cursor++] = elements[curr1++];
        }

        while (curr2 <= right) {
            merged[cursor++] = elements[curr2++];
        }

        // write all elements from merged to elements from left index
        System.arraycopy(merged, 0, elements, left, length);

    }
}
