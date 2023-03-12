package com.qny.logProxy;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: UserServiceProxy.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.logProxy
 * @Time: 2023/3/12 23:37
 */
public class UserServiceProxy implements UserService{
    private UserServiceIMPL userServiceIMPL;

    public void setUserServiceIMPL(UserServiceIMPL userServiceIMPL) {
        this.userServiceIMPL = userServiceIMPL;
    }

    @Override
    public void add() {
        log("add");
        userServiceIMPL.add();
    }

    @Override
    public void update() {
        log("updatel");
        userServiceIMPL.update();
    }

    @Override
    public void delete() {
        log("delete");
        userServiceIMPL.delete();

    }

    @Override
    public void query() {
        log("query");
        userServiceIMPL.query();

    }
    public void log(String msg){
        System.out.println("使用了"+msg+"方法");

    }
}
