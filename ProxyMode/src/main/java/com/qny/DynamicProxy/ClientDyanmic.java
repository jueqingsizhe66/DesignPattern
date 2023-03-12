package com.qny.DynamicProxy;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: ClientDyanmic.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.DynamicProxy
 * @Time: 2023/3/12 23:55
 */
public class ClientDyanmic {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();
        //动态代理角色
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        // 通过调用setRent处理要调用的接口对象
        pih.setRent(host);

        Rent proxy = (Rent)pih.getProxy();
        proxy.rent();
    }
}
