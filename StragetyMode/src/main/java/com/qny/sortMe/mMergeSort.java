package com.qny.sortMe;

/**
 * Multi-Threaded MergeSort
 * @author Alex Hartford
 * Course: CS3851-021
 * Assignment: Lab 4 - Parallel Sorting
 * Spring 2017-2018
 * 19 April 2018
 */
public class mMergeSort implements Algorithm {

    private static int threadCount = 0;

    @Override
    public long sort(int[] A) {
        long startTime = System.nanoTime();
        sort(A, 0, A.length - 1);
//        System.out.println("[MT MergeSort] Sorted Array: " + Arrays.toString(A));
        return System.nanoTime() - startTime;
    }

    public String getName() {
        return "mMergeSort";
    }

    private void merge(int A[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i = 0; i < n1; i++) L[i] = A[l + i];
        for (int i = 0; i < n2; i++) R[i] = A[m + i + 1];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            }
            else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }

    public int[] sort(int[] A, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            if (threadCount < 6) {
                synchronized (this) {
                    threadCount += 2;
                }

                Thread t1 = new Thread(() -> sort(A, l, m));
                Thread t2 = new Thread(() -> sort(A, m + 1, r));

                t1.start();
                t2.start();

                try {
                    t1.join();
                    t2.join();
                    synchronized (this) {
                        threadCount -= 2;
                    }
                } catch (InterruptedException e) {
                    System.out.println("[MergeSort] Threads failed to join");
                    e.printStackTrace();
                }
            } else {
                sort(A, l, m);
                sort(A, m + 1, r);
            }

            merge(A, l, m, r);
        }
        return A;
    }
}
