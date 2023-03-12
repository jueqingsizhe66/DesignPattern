package com.qny.building;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Builder.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.building
 * @Time: 2023/3/12 18:07
 */
public abstract class Builder {
    abstract void buildA(); //地基
    abstract void buildB(); //钢筋工程
    abstract void buildC(); //铺电线
    abstract void buildD(); //粉刷

    //完工，组装，获得一个产品，主机厂家攒出来一台电脑
    abstract Product getProduct();

}
