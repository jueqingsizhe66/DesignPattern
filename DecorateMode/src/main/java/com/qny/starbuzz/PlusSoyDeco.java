package com.qny.starbuzz;

import java.util.zip.Deflater;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: PlusSoyDeco.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.starbuzz
 * @Time: 2023/3/12 0:04
 */
public class PlusSoyDeco extends CondimentDecorator {
    public PlusSoyDeco(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 1.3;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " soy ";
    }
}
