package com.qny.adapater2;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: AdapterWuXianWangKa.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.adapater2
 * @Time: 2023/3/12 17:09
 */
//无线网卡  内置无线网卡 不需要网线
    // 一般所有的继承都可以通过组合来修改
public class AdapterWuXianWangKa extends Adaptee implements NetToUSB{

    @Override
    public void handleRequest() {
        super.request();
    }
}
