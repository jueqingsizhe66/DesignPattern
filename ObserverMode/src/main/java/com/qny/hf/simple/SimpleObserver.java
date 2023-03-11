package com.qny.hf.simple;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: SimpleObserver.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.hf.simple
 * @Time: 2023/3/11 22:29
 */
public class SimpleObserver implements EObserver{
    private int value;
    private ESubject simpleSubject;

    public SimpleObserver(ESubject simpleSubject) {
        this.simpleSubject = simpleSubject;
        simpleSubject.registerObserver(this);
    }

    @Override
    public void update(int value) {

        this.value = value;
        display();
    }

    public void display() {
        System.out.println("Value : "+ value);
    }
}
