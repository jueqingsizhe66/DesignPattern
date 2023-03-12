package com.qny.DynamicProxyAbstract;

import com.qny.DynamicProxy.Rent;

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
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

//        log("add");
        log(method.getName());
        //动态代理的本质就是使用反射  没有像之前的Lianjia类的处理逻辑是写死的
        Object result = method.invoke(target,args);// 调用房东的核心租房业务
        return result;
    }
    public void log(String msg){
        System.out.println("执行了"+msg+"方法");
    }

}
