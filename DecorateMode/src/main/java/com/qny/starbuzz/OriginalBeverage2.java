package com.qny.starbuzz;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: OriginalBeverage2.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.starbuzz
 * @Time: 2023/3/12 0:00
 */
public class OriginalBeverage2 extends Beverage{
    public OriginalBeverage2() {
        description="Original Beverage 2" ;
    }

    @Override
    public double cost() {
        return 1.33;
    }
}
