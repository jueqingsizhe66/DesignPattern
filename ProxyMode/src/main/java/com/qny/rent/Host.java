package com.qny.rent;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Host.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.rent
 * @Time: 2023/3/12 23:25
 */
public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
