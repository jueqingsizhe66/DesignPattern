package com.qny.adapater2;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: AdapterComposite.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.adapater2
 * @Time: 2023/3/12 17:14
 */
public class AdapterComposite implements NetToUSB{
    // 带上一个上网对象
    private Adaptee adaptee;

    public AdapterComposite(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequest() {
        // 通过调用上网源头的adaptee也可以上网
        adaptee.request();
    }
}
