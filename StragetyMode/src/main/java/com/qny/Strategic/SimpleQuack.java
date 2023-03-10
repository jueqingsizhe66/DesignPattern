package com.qny.Strategic;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: SimpleQuack.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.Strategic
 * @Time: 2023/3/11 0:42
 */
public class SimpleQuack implements IQuack{
    @Override
    public void quack() {
        System.out.println("Simple Quack");
    }
}
