package com.qny.SortDogCatNo;

import java.util.Comparator;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Sorter.java
 * @Description:  做个约定 只有实现了Comparator接口的类才可以进行sort
 * @Package com.qny.SortDogCat
 * @Time: 2023/3/14 0:03
 */
public class SorterComparable<T> {
    public void sort(Comparable[] arr) {
        for(int i=0; i<arr.length - 1; i++) {
            int minPos = i;

            for(int j=i+1; j<arr.length; j++) {
                // Comparable 对应compareTo     Comparator 对应compare
                minPos = arr[j].compareTo(arr[minPos])==-1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    //sort(int)

    void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
