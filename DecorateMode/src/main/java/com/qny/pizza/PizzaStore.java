package com.qny.pizza;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: PizzaStore.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.pizza
 * @Time: 2023/3/11 23:49
 */
public class PizzaStore {
    public static void main(String[] args) {
        Pizza pizza = new ThickCrustPizza();
        Pizza cheesePizza = new Cheese(pizza);
        Pizza olivePizza = new Olive(pizza);

        System.out.println(cheesePizza.description+ "\n " + cheesePizza.cost());
        System.out.println(olivePizza.description+ "\n " + olivePizza.cost());
    }
}
