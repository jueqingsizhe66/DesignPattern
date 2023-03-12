package com.qny.FactoryMethod;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Mobai.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.FactoryMethod
 * @Time: 2023/3/12 23:13
 */
public class Mobai implements Car{
    @Override
    public void name() {
        System.out.println("摩拜单车");
    }
}
