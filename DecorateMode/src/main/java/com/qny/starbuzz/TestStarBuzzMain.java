package com.qny.starbuzz;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: TestStarBuzzMain.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.starbuzz
 * @Time: 2023/3/12 0:06
 */
public class TestStarBuzzMain {
    public static void main(String[] args) {

        Beverage beverage = new OriginalBeverage2();
        System.out.println(beverage.getDescription()
                + " yuan" + beverage.cost());

        Beverage beverage2 = new OriginalBeverage3();
        beverage2 = new PlusMochaDeco(beverage2);
        beverage2 = new PlusMochaDeco(beverage2);
        beverage2 = new PlusSoyDeco(beverage2);
        System.out.println(beverage2.getDescription()
                + " $" + beverage2.cost());

        Beverage beverage3 = new OriginalBeverage();
        beverage3 = new PlusMochaDeco(beverage3);
        beverage3 = new PlusMilkDeco(beverage3);
        beverage3 = new PlusSoyDeco(beverage3);
        System.out.println(beverage3.getDescription()
                + " $" + beverage3.cost());
    }
}
