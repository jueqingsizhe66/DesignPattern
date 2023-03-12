package com.qny.building;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Director.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.building
 * @Time: 2023/3/12 18:13
 */
//工地的指挥
public class Director {

    public Product build(Builder builder){
        // Builder的具体实现类是Worker
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();

        return builder.getProduct();
    }
}

