package com.qny.SimpleFactory;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: DaZhong.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.SimpleFactory
 * @Time: 2023/3/12 23:04
 */
public class DaZhong implements Car{
    @Override
    public void name() {
        System.out.println("上海大众");
    }
}
