package com.qny.SimpleFactory;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Tesla.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.SimpleFactory
 * @Time: 2023/3/12 22:58
 */
public class Tesla implements Car{
    @Override
    public void name() {
        System.out.println("特斯拉");
    }
}
