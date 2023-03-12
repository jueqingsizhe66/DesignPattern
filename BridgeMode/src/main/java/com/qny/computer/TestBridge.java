package com.qny.computer;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: TestBridge.java
 * @Description: 品牌和 电脑类型区分开
 * 桥接模式 适合破坏多继承关系， 体现组合优于继承的设计理念， 减少系统的分层架构
 * @Package com.qny.computer
 * @Time: 2023/3/12 16:50
 */
public class TestBridge {
    public static void main(String[] args) {
        //华为笔记本
        Computer huaweiLaptop = new Laptop(new Huawei());
        huaweiLaptop.info();

        Computer huaweiDesktop = new Desktop(new Huawei());
        huaweiDesktop.info();
    }
}
