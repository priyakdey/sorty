package com.priyakdey.sorty.impl;

import com.priyakdey.sorty.Sort;

/**
 * @author Priyak Dey
 */
public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] elements) {
        if (elements.length == 1) return;

        for (int i = 0; i < elements.length; i++) {
            T min = elements[i];
            int indexOfMin = i;
            for (int j = i + 1; j < elements.length ; j++) {
                if (elements[j].compareTo(min) < 0 ) {
                    min = elements[j];
                    indexOfMin = j;
                }
            }
            elements[indexOfMin] = elements[i];
            elements[i] = min;
        }
    }
}
