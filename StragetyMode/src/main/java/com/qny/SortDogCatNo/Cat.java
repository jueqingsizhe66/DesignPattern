package com.qny.SortDogCatNo;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Cat.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.SortDogCatNo
 * @Time: 2023/3/14 0:09
 */
public class Cat implements Comparable<Cat>{
    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int compareTo(Cat c) {

        if(this.weight < c.weight) return -1;
        else if(this.weight > c.weight) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
