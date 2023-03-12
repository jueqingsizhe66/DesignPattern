package com.qny.logProxy;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: ClientUser.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.logProxy
 * @Time: 2023/3/12 23:37
 */
public class ClientUser {
    public static void main(String[] args) {
        UserService userService = new UserServiceIMPL();
        userService.add();


        System.out.println("切面编程：");
        // 新的代理接口
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.setUserServiceIMPL(new UserServiceIMPL());
        userServiceProxy.add();
        userServiceProxy.delete();
        userServiceProxy.query();
    }
}
