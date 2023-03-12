package com.qny.FactoryMethod;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: TestFacoryMethod.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.FactoryMethod
 * @Time: 2023/3/12 23:10
 */
public class TestFacoryMethod {
    public static void main(String[] args) {
        CarFactory teslaFacotry = new TeslaFactory();
        Car tesla = teslaFacotry.getCar();
        tesla.name();

        CarFactory wulingFactory = new WulingFactory();
        Car wuling = wulingFactory.getCar();
        wuling.name();

        CarFactory DazhongFactory = new DazhongFactory();
        Car dazhong = DazhongFactory.getCar();
        dazhong.name();

        Car mobai = new MobaiFactory().getCar();
        mobai.name();
    }
}
