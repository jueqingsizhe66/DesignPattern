package com.qny.DynamicProxyAbstract;

import com.qny.logProxy.UserService;
import com.qny.logProxy.UserServiceIMPL;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: ClientAbstract.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.DynamicProxyAbstract
 * @Time: 2023/3/13 0:05
 */
public class ClientAbstract {
    public static void main(String[] args) {
        //真实角色
        UserServiceIMPL userService = new UserServiceIMPL();
        // 代理角色
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
       //设置要代理的对象
        pih.setTarget(userService);
        //动态生成代理类
        UserService proxy = (UserService) pih.getProxy();
        // 所有框架的底层是反射
        proxy.add();
        proxy.delete();
        proxy.query();
        proxy.update();
    }
}
