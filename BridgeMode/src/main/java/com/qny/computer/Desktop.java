package com.qny.computer;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Desktop.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.computer
 * @Time: 2023/3/12 16:49
 */
public class Desktop extends Computer{
    public Desktop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
       super.info();
        System.out.println("台式机");
    }
}
