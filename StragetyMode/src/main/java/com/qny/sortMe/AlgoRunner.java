package com.qny.sortMe;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Driver class.  Decided to implement this in Java for better thread performance (vs. Python)
 * @author Alex Hartford
 * Course: CS3851-021
 * Assignment: Lab 4 - Parallel Sorting
 * Spring 2017-2018
 * 19 April 2018
 */
public class AlgoRunner {

    public static void main(String[] args) {

        ArrayList<int[]> lists = generateLists(100);
        int[] bestCase = lists.get(0);
        int[] worstCase = lists.get(1);
        int[] likelyCase = lists.get(2);

        Algorithm quickSort = new QuickSort();
        Algorithm mergeSort = new MergeSort();

        Algorithm mQuickSort = new mQuickSort();
        Algorithm mMergeSort = new mMergeSort();

        Algorithm IQuickSort = new IQuickSort();
        Algorithm IMQuickSort = new IMQuickSort();

        Algorithm javaCollectionSort = new JavaCollectionSort();
        Algorithm IRQuickSort = new IRQuickSort();

        Algorithm optimalSort = new OptimalSort();

//        runTest("QuickSort", quickSort, "best case", bestCase);
//        runTest("MergeSort", mergeSort, "best case", bestCase);
//        runTest("Multi-Threaded QuickSort", mQuickSort, "best case", bestCase);
//        runTest("Multi-Threaded MergeSort", mMergeSort, "best case", bestCase);
//
//        runTest("QuickSort", quickSort, "worst case", worstCase);
//        runTest("MergeSort", mergeSort, "worst case", worstCase);
//        runTest("Multi-Threaded QuickSort", mQuickSort, "worst case", worstCase);
//        runTest("Multi-Threaded MergeSort", mMergeSort, "worst case", worstCase);

//        runTest("QuickSort", quickSort, "likely", likelyCase);
//        runTest("MergeSort", mergeSort, "likely", likelyCase);
//        runTest("Multi-Threaded QuickSort", mQuickSort, "likely", likelyCase);
//        runTest("Multi-Threaded MergeSort", mMergeSort, "likely", likelyCase);

//        runTest("IQuickSort", IQuickSort, "best case", bestCase);
//        runTest("IQuickSort", IQuickSort, "worst case", worstCase);
//        runTest("IQuickSort", IQuickSort, "likely case", likelyCase);
//
//        runTest("IMQuickSort", IMQuickSort, "best case", bestCase);
//        runTest("IMQuickSort", IMQuickSort, "worst case", worstCase);
//        runTest("IMQuickSort", IMQuickSort, "likely case", likelyCase);

//        runTest(optimalSort.getName(), optimalSort, "best case", bestCase);
//        runTest(optimalSort.getName(), optimalSort, "worst case", worstCase);
//        runTest(optimalSort.getName(), optimalSort, "likely case", likelyCase);

//        comprehensiveAnalysisToCSV(IQuickSort, IMQuickSort, mergeSort, mMergeSort, javaCollectionSort, IRQuickSort);
        comprehensiveAnalysisToCSV(optimalSort);
    }

    /**
     * Returns best case, worst case, and most likely case lists to be analyzed.
     * @param inputLength - How long the lists will be
     * @return an ArrayList that can be indexed to get each list. Index 0 = best, 1 = worst, 2 = likely
     */
    private static ArrayList<int[]> generateLists(int inputLength) {
        Random random = new Random();

        int[] bestCase = new int[inputLength];
        int[] worstCase = new int[inputLength];
        int[] likelyCase = new int[inputLength];

        for (int i = 0; i < inputLength; i++) {
            bestCase[i] = i;
            worstCase[i] = inputLength - i;
            likelyCase[i] = random.nextInt(inputLength * 10);
        }

        ArrayList<int[]> listOfLists = new ArrayList<>();
        listOfLists.add(bestCase);
        listOfLists.add(worstCase);
        listOfLists.add(likelyCase);

        return listOfLists;
    }

    /**
     * Takes a generic list and makes a deep copy to guarantee it's not sorted by another algorithm
     * @param A - Array to make a deep copy of
     * @return a deep copy of the input array A
     */
    private static int[] unique(int[] A) {
        int[] Au = new int[A.length];
        System.arraycopy(A, 0, Au, 0, A.length);
        return Au;
    }

    /**
     * Runs a specified algorithm on a specified list and prints relevant data
     * @param name - name of the algorithm, e.g. QuickSort
     * @param algo - the algorithm to run, e.g. Multi-Threaded QuickSort
     * @param inputName - the type of input, e.g. "likely"
     * @param input - the input to sort, e.g. [0, 1, 2, 5, 6, 4, 3]
     */
    private static void runTest(String name, Algorithm algo, String inputName, int[] input) {
        System.out.println("[" + inputName + "] " + name + " sorted" +
//                Arrays.toString(input) +
                " in " + algo.sort(unique(input)) + "ns");

    }

    /**
     * Huge workhorse that generates a csv file from running every algorithm on every set of input
     * Would have cleaned it up more but I plan to move back to Python after this threading lab.
     * @param algos - any algorithms I want to run the script on (always all 4)
     *           In this order: Quicksort -> mergesort -> mQuicksort -> mMergesort
     */
    private static void comprehensiveAnalysisToCSV(Algorithm... algos) {

        int numIterations = 5;

        ArrayList<int[]> bestLists = new ArrayList<>();
        ArrayList<int[]> worstLists = new ArrayList<>();
        ArrayList<int[]> likelyLists = new ArrayList<>();

        // populates lists with length 1000, 10000, 100000, 1000000, 10000000
        for (int i = 1000000; i <= 10000000; i += 200000) { // BIG N
//        for (int i = 1000; i < 1000000; i += 5000) { // SMALL N
            ArrayList<int[]> lists = generateLists(i);
            bestLists.add(lists.get(0));
            worstLists.add(lists.get(1));
            likelyLists.add(lists.get(2));
        }

        try {
            Writer writer = new BufferedWriter(
                            new OutputStreamWriter(
                            new FileOutputStream("big2CCS3851Lab4.csv")));

            for (Algorithm algo : algos) {
                writer.write(algo.getName() + "\n");
                writer.write("n,best,worst,likely\n");
                for (int i = 0; i < bestLists.size(); i++) {
                    writer.write(bestLists.get(i).length + ",");
                    long time = 0;
                    for (int j = 0; j < numIterations; j++) {
                        time += algo.sort(unique(bestLists.get(i)));
                    }
                    writer.write(time / numIterations + ",");
                    time = 0;
                    for (int j = 0; j < numIterations; j++) {
                        time += algo.sort(unique(worstLists.get(i)));
                    }
                    writer.write(time / numIterations + ",");
                    time = 0;
                    for (int j = 0; j < numIterations; j++) {
                        time += algo.sort(unique(likelyLists.get(i)));
                    }
                    writer.write(time / numIterations + "\n");
                }
            }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
