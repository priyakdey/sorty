package com.priyakdey.sorty.impl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.priyakdey.sorty.Sort;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("SelectionSortTest")
class SelectionSortTest {

    private static Sort<Integer> sorter;

    @BeforeAll
    public static void setup() {
        sorter = new SelectionSort<>();
    }

    public static Stream<Arguments> arrayFixtures() {
        return Stream.of(
            Arguments.of(new Integer[] {4, 5, 1, 2, 3, 4}, new Integer[] {1, 2, 3, 4, 4, 5}),
            Arguments.of(new Integer[] {14, 5, 1, 2, 3, 4}, new Integer[] {1, 2, 3, 4, 5, 14}),
            Arguments.of(new Integer[] {1, 2, 3, 4, 5, 6}, new Integer[] {1, 2, 3, 4, 5, 6}),
            Arguments.of(new Integer[] {4, 5, 1, 20, 3, 4}, new Integer[] {1, 3, 4, 4, 5, 20})
        );
    }


    @ParameterizedTest(name = "Test #{index}")
    @MethodSource("arrayFixtures")
    void sort(Integer[] elements, Integer[] expected) {
        sorter.sort(elements);
        final String errMsg = String.format("expected %s, but got %s", Arrays.toString(expected),
            Arrays.toString(elements));
        assertArrayEquals(expected, elements, errMsg);
    }

}