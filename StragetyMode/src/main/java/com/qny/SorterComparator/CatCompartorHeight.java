package com.qny.SorterComparator;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: CatCompartorHeight.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.SorterComparator
 * @Time: 2023/3/14 0:20
 */
public class CatCompartorHeight implements Comparator<Cat>{
    @Override
    public int compare(Cat o1, Cat o2) {
        if(o1.height > o2.height) return -1;
        else if (o1.height < o2.height) return 1;
        else return 0;
    }
}
