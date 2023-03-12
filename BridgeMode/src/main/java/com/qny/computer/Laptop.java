package com.qny.computer;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Laptop.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.computer
 * @Time: 2023/3/12 16:49
 */
public class Laptop extends Computer{
    public Laptop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("笔记本");
    }
}
