package com;

import java.util.Arrays;
import java.util.Comparator;

public class TestComparator {
    public static void main(String[] args) {
        //数组
        Integer[] dataSeries = new Integer[]{1,2,3,45,3,5,642,34,4,2};

        //实现升序

        System.out.println(dataSeries);
        // 实现Comparator接口
        // Comparator Integer策略接口    compare指定处理方式(处理方式的策略封装)
        Comparator<Integer> comparatorAcc = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2){
                    return 1;
                }else{
                    return -1;
                }

            }

        };

        Comparator<Integer> comparatorDesc = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2){
                    return -1;
                }else{
                    return 1;
                }

            }

        };
        Arrays.sort(dataSeries,comparatorAcc);
        System.out.println("up up up ------"+Arrays.toString(dataSeries));


        Arrays.sort(dataSeries,comparatorDesc);
        System.out.println("down down down ------------"+Arrays.toString(dataSeries));


        Integer[] dataSeries2 = new Integer[]{1,12,13,45,3,25,42,334,4,2};
        Arrays.sort(dataSeries2,(var1,var2)->{
            if(var1.compareTo(var2) >0){
                return 1;
            }else{
                return -1;
            }
        });

        System.out.println(Arrays.toString(dataSeries2));
    }
}
