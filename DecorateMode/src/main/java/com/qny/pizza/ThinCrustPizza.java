package com.qny.pizza;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: ThinCrustPizza.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.pizza
 * @Time: 2023/3/11 23:44
 */
public class ThinCrustPizza extends Pizza{
    public ThinCrustPizza() {
        description = " Thin  Crust pizza  with a little tomato";
    }

    @Override
    public double cost() {
        return 5;
    }
}
