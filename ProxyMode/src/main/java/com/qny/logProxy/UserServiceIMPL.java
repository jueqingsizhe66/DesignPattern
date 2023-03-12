package com.qny.logProxy;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: UserServiceIMPL.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.logProxy
 * @Time: 2023/3/12 23:36
 */
public class UserServiceIMPL implements UserService{

    @Override
    public void add() {
        System.out.println("添加");
    }

    @Override
    public void update() {
        System.out.println("更新");

    }

    @Override
    public void delete() {
        System.out.println("删除");

    }

    @Override
    public void query() {
        System.out.println("查找");

    }
}
