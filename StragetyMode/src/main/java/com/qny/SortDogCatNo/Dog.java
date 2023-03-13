package com.qny.SortDogCatNo;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Dog.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.SortDogCatNo
 * @Time: 2023/3/14 0:10
 */
public class Dog implements Comparable<Dog>{
    int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareTo(Dog d) {
        if(this.food < d.food) return -1;
        else if(this.food > d.food) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
