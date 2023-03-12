package com.qny.abstractFactory;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: TestAbsFactory.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.abstractFactory
 * @Time: 2023/3/12 20:26
 */
public class TestAbsFactory {
    public static void main(String[] args) {
        System.out.println("****************小米产品系列***************");
        XiaomiFactory xiaomi = new XiaomiFactory();
        IPhoneProduct xiaomiPhone= xiaomi.iphoneProduct();
        xiaomiPhone.start();
        xiaomiPhone.sendMSG();
        xiaomiPhone.stop();
       IRouteProduct xiaomiRoute = xiaomi.irouteProduct();
       xiaomiRoute.start();
       xiaomiRoute.openWifi();
       xiaomiRoute.stop();

        System.out.println("****************华为产品系列***************");
        HuaweiFactory huawei = new HuaweiFactory();
        IPhoneProduct huaweiPhone= huawei.iphoneProduct();
        huaweiPhone.start();
        huaweiPhone.sendMSG();
        huaweiPhone.stop();
        IRouteProduct huaweiRoute = huawei.irouteProduct();
        huaweiRoute.start();
        huaweiRoute.openWifi();
        huaweiRoute.stop();
    }
}
