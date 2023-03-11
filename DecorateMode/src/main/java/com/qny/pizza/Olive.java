package com.qny.pizza;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Olive.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.pizza
 * @Time: 2023/3/11 23:48
 */
public class Olive extends ToppingPizza{
    public Olive(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double cost() {
        return pizza.cost()+0.6;// olive is expensive
    }

    @Override
    public String getDescription() {
        return pizza.description+ "， Olive";
    }
}
