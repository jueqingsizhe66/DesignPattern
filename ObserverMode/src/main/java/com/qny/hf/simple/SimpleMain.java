package com.qny.hf.simple;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: SimpleMain.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.hf.simple
 * @Time: 2023/3/11 22:35
 */
public class SimpleMain {
    public static void main(String[] args) {
        SimpleSubject simpleSubject = new SimpleSubject();
        SimpleObserver simpleObserver = new SimpleObserver(simpleSubject);
        simpleSubject.setValue(20);

        simpleSubject.removeObserver(simpleObserver);
    }
}
