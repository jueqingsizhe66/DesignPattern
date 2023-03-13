package com.qny.SorterComparator;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: DogComparator.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.SorterComparator
 * @Time: 2023/3/14 0:21
 */
public class DogComparator implements Comparator<Dog>{
    @Override
    public int compare(Dog o1, Dog o2) {
        if(o1.food < o2.food) return -1;
        else if (o1.food > o2.food) return 1;
        else return 0;
    }
}
