package com.qny.pizza;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Cheese.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.pizza
 * @Time: 2023/3/11 23:45
 */
public class Cheese extends ToppingPizza{
    public Cheese(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.description+ ",cheese ";
    }

    @Override
    public double cost() {
        return pizza.cost(); //cheese is free
    }
}
