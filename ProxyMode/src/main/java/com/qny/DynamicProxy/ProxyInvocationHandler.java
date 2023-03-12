package com.qny.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: ProxyInvocationHandler.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.DynamicProxy
 * @Time: 2023/3/12 23:51
 */
public class ProxyInvocationHandler implements InvocationHandler {
    /// 处理代理实例 返回结果
    // 被代理的对象
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //动态代理的本质就是使用反射  没有像之前的Lianjia类的处理逻辑是写死的
        visitHouse();
        Object result = method.invoke(rent,args);// 调用房东的核心租房业务
        contract();
        fare();
        return result;
    }

    public void visitHouse(){
        System.out.println("中介带你看房");
    }

    /**
     * 收中介费
     */
    public void fare(){
        System.out.println("收中介费");
    }

    /**
     * 租赁合同
     */
    public void contract(){
        System.out.println("中介签署合同");
    }
}
