package com.qny.sortMe;


import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Iterative Multi-Threaded QuickSort with O(n) complexity for pre-sorted data
 * @author Alex Hartford
 * Course: CS3851-021
 * Assignment: Lab 4 - Parallel Sorting
 * Spring 2017-2018
 * 19 April 2018
 */
public class OptimalSort implements Algorithm {


    private final static int CPUCores = Runtime.getRuntime().availableProcessors();

    private int[] A;

    public String getName() {
        return "OptimalSort";
    }

    @Override
    public long sort(int[] A) {
        long startTime = System.nanoTime();
        if (sorted_ascending(A)) {
            return System.nanoTime() - startTime;
        } else if (sorted_descending(A)) {
            ArrayUtils.reverse(A); //apache lang3
            return System.nanoTime() - startTime;
        } else {
            sort(A, 0, A.length - 1);
        }
//        System.out.println("[OptimalSort] Sorted Array: " + Arrays.toString(A));
        return System.nanoTime() - startTime;
    }

    private boolean sorted_ascending(int A[]) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean sorted_descending(int A[]) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int[] sort(int[] A, int lower, int upper) {
        this.A = A;
        ForkJoinPool pool = new ForkJoinPool();
        this.sort(pool);
        return A;
    }

    private void sort(ForkJoinPool pool) {
        RecursiveAction start = new Partition(0, A.length - 1);
        pool.invoke(start);
    }

    // inner class allows use of recursiveaction
    private class Partition extends RecursiveAction {
        int lowerBound;
        int upperBound;

        private Partition(int lowerBound, int upperBound) {

            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }

        private int size() {
            return upperBound - lowerBound;
        }

        protected void compute() {
//            ForkJoinPool pool = getPool();
//            System.out.println("active threads: " + pool.getRunningThreadCount());
            int lower = lowerBound;
            int upper = upperBound;

            swap(A, lower + ((upper - lower) / 2), upper);
            int temp = A[upper];

            int i = lower - 1;
            for(int j = lower; j < upper; j++) {
                if(A[j] <= temp) {
                    i++;
                    swap(A, i, j);
                }
            }
            swap(A, i + 1, upper);

            int pivot = i + 1;

            Partition leftTask = null;
            Partition rightTask = null;

            if (lowerBound < pivot - 1) {
                leftTask = new Partition(lowerBound, pivot - 1);
            }
            if (pivot < upperBound) {
                rightTask = new Partition(pivot + 1, upperBound);
            }

            if (size() > CPUCores * 2) {
                if (leftTask != null && rightTask != null) {
                    invokeAll(leftTask, rightTask);
                } else if (leftTask != null) {
                    invokeAll(leftTask);
                } else if (rightTask != null) {
                    invokeAll(rightTask);
                }
            } else {
                if (leftTask != null) {
                    leftTask.compute();
                }
                if (rightTask != null) {
                    rightTask.compute();
                }
            }
        }

        private void swap(int[] A, int firstIndex, int secondIndex) {
            int temp = A[firstIndex];
            A[firstIndex] = A[secondIndex];
            A[secondIndex] = temp;
        }
    }
}
