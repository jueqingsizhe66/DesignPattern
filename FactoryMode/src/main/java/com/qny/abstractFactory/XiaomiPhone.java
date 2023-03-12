package com.qny.abstractFactory;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: XiaomiPhone.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.abstractFactory
 * @Time: 2023/3/12 20:22
 */
public class XiaomiPhone implements IPhoneProduct{
    @Override
    public void start() {
        System.out.println("小米手机开机");
    }

    @Override
    public void stop() {
        System.out.println("小米手机关机");

    }

    @Override
    public void callUp() {
        System.out.println("小米手机打电话");

    }

    @Override
    public void sendMSG() {
        System.out.println("小米手机发短信");

    }
}
