package com.qny.sortMe;

import java.util.Arrays;
import java.util.Stack;

/**
 * Iterative Single-Threaded QuickSort
 * Recursive QuickSort was giving me stackoverflow errors so here we are.
 * @author Alex Hartford
 * Course: CS3851-021
 * Assignment: Lab 4 - Parallel Sorting
 * Spring 2017-2018
 * 19 April 2018
 */
public class IQuickSort implements Algorithm {

    @Override
    public long sort(int[] A) {
        long startTime = System.nanoTime();
        iterativeQuicksort(A);
//        System.out.println("[Iterative QuickSort] Sorted Array: " + Arrays.toString(A));
        return System.nanoTime() - startTime;
    }

    public String getName() {
        return "IQuickSort";
    }

    public int[] sort(int[] A, int lower, int upper) {
        return iterativeQuicksort(A);
    }

    private int[] iterativeQuicksort(int[] A) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(A.length - 1);
        while(!stack.isEmpty()) {
            int upper = stack.pop();
            int lower = stack.pop();
            if (upper - lower > 0) {
                int pivot = partition(A, lower, upper);

                stack.push(pivot + 1);
                stack.push(upper);

                stack.push(lower);
                stack.push(pivot - 1);
            }
        }
        return A;
    }

    private int partition(int[] A, int lower, int upper) {

        swap(A, lower + ((upper - lower) / 2), upper);
        int pivot = A[upper];

        int i = lower - 1;
        for(int j = lower; j < upper; j++) {
            if(A[j] <= pivot) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, upper);

        return i + 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
