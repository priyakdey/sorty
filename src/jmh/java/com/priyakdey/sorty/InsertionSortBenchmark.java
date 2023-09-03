package com.priyakdey.sorty;

import com.priyakdey.sorty.impl.BinarySearchInsertionSort;
import com.priyakdey.sorty.impl.ClassicInsertionSort;
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
 * @author Priyak Dey
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class InsertionSortBenchmark {

    private static final int SIZE = 1000;
    private Integer[] classicArray;
    private Integer[] binarySearchArray;

    @Setup(Level.Trial)
    public void setUp() {
        // Initialize the arrays with random integers
        classicArray = new Integer[SIZE];
        binarySearchArray = new Integer[SIZE];
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            classicArray[i] = random.nextInt(SIZE);
            // copy values so that both algorithms work on the same data
            binarySearchArray[i] = classicArray[i];
        }
    }

    @Benchmark
    public void benchmarkClassicInsertionSort() {
        ClassicInsertionSort<Integer> sort = new ClassicInsertionSort<>();
        sort.sort(classicArray);
    }

    @Benchmark
    public void benchmarkBinarySearchInsertionSort() {
        BinarySearchInsertionSort<Integer> sort = new BinarySearchInsertionSort<>();
        sort.sort(binarySearchArray);
    }

}
