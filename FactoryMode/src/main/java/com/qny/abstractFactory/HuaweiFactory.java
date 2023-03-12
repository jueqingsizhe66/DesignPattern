package com.qny.abstractFactory;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: HuaweiFactory.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.abstractFactory
 * @Time: 2023/3/12 20:25
 */
public class HuaweiFactory implements IProductFactory{

    @Override
    public IPhoneProduct iphoneProduct() {
        return new HuaweiPhone();
    }

    @Override
    public IRouteProduct irouteProduct() {
        return new HuaweiRouter();
    }
}
