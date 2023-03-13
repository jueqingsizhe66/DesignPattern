package com.qny.SorterComparator;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Cat.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.SorterComparator
 * @Time: 2023/3/14 0:19
 */
public class Cat {
    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
