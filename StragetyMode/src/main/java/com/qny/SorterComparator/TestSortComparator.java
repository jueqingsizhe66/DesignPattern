package com.qny.SorterComparator;

import java.util.Arrays;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: TestSortComparator.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.SorterComparator
 * @Time: 2023/3/14 0:23
 */
public class TestSortComparator {
    public static void main(String[] args) {
        //int[] a = {9, 2, 3, 5, 7, 1, 4};
        Cat[] a = {new Cat(3, 3), new Cat(5, 5), new Cat(1, 1)};
        //Dog[] a = {new Dog(3), new Dog(5), new Dog(1)};
        SorterCompartor<Cat> sorter = new SorterCompartor<>();
        sorter.sort(a, (o1, o2)->{
            if(o1.weight < o2.weight) return -1;
            else if (o1.weight>o2.weight) return 1;
            else return 0;
        });
        System.out.println(Arrays.toString(a));

        SorterCompartor<Cat> sorter2 = new SorterCompartor<>();
        sorter2.sort(a,new CatCompartorHeight());
        System.out.println(Arrays.toString(a));


        SorterCompartor<Cat> sorter3 = new SorterCompartor<>();
        sorter3.sort(a,new CatComparatorWeight());
        System.out.println(Arrays.toString(a));


        Dog[] b = {new Dog(3), new Dog(5), new Dog(1)};
        SorterCompartor<Dog> sorter4 = new SorterCompartor<>();
        sorter4.sort(b,new DogComparator());
        System.out.println(Arrays.toString(b));
    }
}
