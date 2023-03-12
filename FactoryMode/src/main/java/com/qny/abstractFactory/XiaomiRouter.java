package com.qny.abstractFactory;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: XiaomiRouter.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.abstractFactory
 * @Time: 2023/3/12 20:23
 */
public class XiaomiRouter implements IRouteProduct{
    @Override
    public void start() {
        System.out.println("小米路由器开机");
    }

    @Override
    public void stop() {
        System.out.println("小米路由器停机");

    }

    @Override
    public void openWifi() {
        System.out.println("小米路由器打开wifi");

    }

    @Override
    public void setting() {
        System.out.println("小米路由器设置");

    }
}
