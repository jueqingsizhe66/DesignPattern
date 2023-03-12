package com.qny.abstractFactory;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: HuaweiPhone.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.abstractFactory
 * @Time: 2023/3/12 20:23
 */
public class HuaweiPhone implements IPhoneProduct{

    @Override
    public void start() {
        System.out.println("华为手机开机");
    }

    @Override
    public void stop() {
        System.out.println("华为手机关机");

    }

    @Override
    public void callUp() {
        System.out.println("华为手机打电话");

    }

    @Override
    public void sendMSG() {

        System.out.println("华为手机发短信");
    }
}
