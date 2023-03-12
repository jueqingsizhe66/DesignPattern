package com.qny.abstractFactory;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: HuaweiRouter.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.abstractFactory
 * @Time: 2023/3/12 20:24
 */
public class HuaweiRouter implements IRouteProduct{
    @Override
    public void start() {
        System.out.println("华为路由器开机");
    }

    @Override
    public void stop() {
        System.out.println("华为路由器关机");

    }

    @Override
    public void openWifi() {
        System.out.println("华为路由器打开wifi");

    }

    @Override
    public void setting() {

        System.out.println("华为路由器设置");
    }
}
