package com.qny.SorterComparator;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: SorterCompartor.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.SorterComparator
 * @Time: 2023/3/14 0:22
 */
public class SorterCompartor<T> {
    public void sort(T[] arr, Comparator<T> comparator) {
        for(int i=0; i<arr.length - 1; i++) {
            int minPos = i;

            for(int j=i+1; j<arr.length; j++) {
                minPos = comparator.compare(arr[j],arr[minPos])==-1 ? j : minPos;
            }
            swap(arr, i, minPos);
        }
    }

    //sort(int)

    void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
