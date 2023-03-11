package com.qny.starbuzz;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: OriginalBeverage3.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.starbuzz
 * @Time: 2023/3/12 0:01
 */
public class OriginalBeverage3 extends Beverage{
    public OriginalBeverage3() {
        description = "Original Beverage 3";
    }

    @Override
    public double cost() {
        return 2.3;
    }
}
