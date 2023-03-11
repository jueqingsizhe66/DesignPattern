package com.qny.starbuzz;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: PlusMilkDeco.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.starbuzz
 * @Time: 2023/3/12 0:02
 */
public class PlusMilkDeco extends CondimentDecorator{
    public PlusMilkDeco(Beverage beverage) {
        this.beverage = beverage;

    }

    @Override
    public double cost() {
        return beverage.cost()+ 0.3;
    }

    @Override
    public String getDescription() {
        return beverage.description+", milk";
    }
}
