package com.qny.pizza;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: ThickCrustPizza.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.pizza
 * @Time: 2023/3/11 23:42
 */
public class ThickCrustPizza extends Pizza{
    public ThickCrustPizza() {
        description = "Thick crust pizza, with tomato sauce";
    }

    @Override
    public double cost() {
        return 7.99;
    }
}
