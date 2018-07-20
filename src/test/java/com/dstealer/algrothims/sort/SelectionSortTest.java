package com.dstealer.algrothims.sort;

import com.dstealer.algrothims.common.Assistant;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;

public class SelectionSortTest {
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void sort() {
        int[] arr = Assistant.generateRandomArray(10, 100);
        //Assistant.print(arr, 10);
        SelectionSort.sort(arr);
        //Assistant.print(arr, 10);
        Assistant.checkAsc(arr);
    }
}