package com.qny.sortMe;

import java.util.Arrays;

public class JavaCollectionSort implements Algorithm {

    @Override
    public String getName() {
        return "JavaCollectionSort";
    }

    @Override
    public long sort(int[] A) {
        long startTime = System.nanoTime();
        Arrays.sort(A);
        return System.nanoTime() - startTime;
    }

    @Override
    public int[] sort(int[] A, int lower, int upper) {
        return new int[0];
    }
}
