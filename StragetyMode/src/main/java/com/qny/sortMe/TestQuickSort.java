package com.qny.sortMe;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: TestQuickSort.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.sortMe
 * @Time: 2023/3/13 23:54
 */
public class TestQuickSort {
    public static void quickSort(int arr[], int begin, int end) {
        if(begin < end) {

            // partitionIndex is partitioning index, arr[p]
            // is now at right place
            int partitionIndex = partition(arr, begin, end);


            // Separately sort elements before
            // partition and after partition
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        //to swap the two elements
        for (int j = begin; j < end; j++) {
            if(arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;


            }
        }
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }


    // Function to print an array
    static void printArray(int[] arr, int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }



    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;

        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        printArray(arr, n);

    }
}
