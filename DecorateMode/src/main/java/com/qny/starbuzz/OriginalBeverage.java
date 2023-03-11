package com.qny.starbuzz;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: OriginalBeverage.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.starbuzz
 * @Time: 2023/3/11 23:59
 */
public class OriginalBeverage extends Beverage{

    public OriginalBeverage() {
        description="Origianl Beverage";
    }

    @Override
    public double cost() {
        return 0.9;
    }
}
