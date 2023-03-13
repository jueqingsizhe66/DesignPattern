package com.qny.sortMe;

/**
 * Generic Algorithm Interface
 * @author Alex Hartford
 * Course: CS3851-021
 * Assignment: Lab 4 - Parallel Sorting
 * Spring 2017-2018
 * 19 April 2018
 */
public interface Algorithm {

    String getName();

    long sort(int[] A);

    int[] sort(int[] A, int lower, int upper);
}

