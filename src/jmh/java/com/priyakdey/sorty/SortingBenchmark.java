package com.priyakdey.sorty;

import com.priyakdey.sorty.impl.BinarySearchInsertionSort;
import com.priyakdey.sorty.impl.BubbleSort;
import com.priyakdey.sorty.impl.ClassicInsertionSort;
import com.priyakdey.sorty.impl.MergeSort;
import com.priyakdey.sorty.impl.SelectionSort;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * Class to benchmark all sorting algorithms
 *
 * @author Priyak Dey
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class SortingBenchmark {

    private static final int SIZE = 10000;
    private Integer[] bubbleSortArray;
    private Integer[] selectionSortArray;
    private Integer[] classicInsertionArray;
    private Integer[] binarySearchInsertionArray;
    private Integer[] mergeSortArray;

    @Setup(Level.Invocation)
    public void setUp() {
        // Initialize the arrays with random integers
        bubbleSortArray = new Integer[SIZE];
        selectionSortArray = new Integer[SIZE];
        classicInsertionArray = new Integer[SIZE];
        binarySearchInsertionArray = new Integer[SIZE];
        mergeSortArray = new Integer[SIZE];

        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            int num = random.nextInt(SIZE);

            // copy values so that all algorithms work on the same data
            bubbleSortArray[i] = num;
            selectionSortArray[i] = num;
            classicInsertionArray[i] = num;
            binarySearchInsertionArray[i] = num;
            mergeSortArray[i] = num;
        }
    }


    /**
     * Benchmark test for {@link BubbleSort}
     */
    @Benchmark
    public void benchmarkBubbleSort() {
        Sort<Integer> sort = new BubbleSort<>();
        sort.sort(bubbleSortArray);
    }

    /**
     * Benchmark test for {@link SelectionSort}
     */
    @Benchmark
    public void benchmarkSelectionSort() {
        Sort<Integer> sort = new SelectionSort<>();
        sort.sort(selectionSortArray);
    }

    /**
     * Benchmark test for {@link ClassicInsertionSort}
     */
    @Benchmark
    public void benchmarkClassicInsertionSort() {
        Sort<Integer> sort = new ClassicInsertionSort<>();
        sort.sort(classicInsertionArray);
    }

    /**
     * Benchmark test for {@link BinarySearchInsertionSort}
     */
    @Benchmark
    public void benchmarkBinarySearchInsertionSort() {
        Sort<Integer> sort = new BinarySearchInsertionSort<>();
        sort.sort(binarySearchInsertionArray);
    }


    /**
     * Benchmark test for @{@link MergeSort}
     */
    @Benchmark
    public void benchmarkMergeSort() {
        Sort<Integer> sort = new MergeSort<>();
        sort.sort(mergeSortArray);
    }

}
