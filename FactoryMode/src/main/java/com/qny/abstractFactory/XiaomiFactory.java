package com.qny.abstractFactory;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: XiaomiFactory.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.abstractFactory
 * @Time: 2023/3/12 20:25
 */
public class XiaomiFactory implements IProductFactory{
    @Override
    public IPhoneProduct iphoneProduct() {
        return new XiaomiPhone();
    }

    @Override
    public IRouteProduct irouteProduct() {
        return new XiaomiRouter();
    }
}
