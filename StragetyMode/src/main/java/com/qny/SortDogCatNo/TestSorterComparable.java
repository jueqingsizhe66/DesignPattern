package com.qny.SortDogCatNo;

import java.util.Arrays;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: TestSorterComparable.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.SortDogCatNo
 * @Time: 2023/3/14 0:14
 */
public class TestSorterComparable {
    public static void main(String[] args) {
        //int[] a = {9, 2, 3, 5, 7, 1, 4};
        Cat[] a = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};
        SorterComparable<Cat> sorter = new SorterComparable<>();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));

        Dog[] b = {new Dog(3), new Dog(5), new Dog(1)};
        sorter.sort(b);
        System.out.println(Arrays.toString(b));
    }
}
