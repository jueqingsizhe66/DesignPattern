package com.qny.hf.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: SimpleSubject.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.hf.simple
 * @Time: 2023/3/11 22:32
 */
public class SimpleSubject implements ESubject{
    private List<EObserver> observerList;

    public SimpleSubject() {
        this.observerList = new ArrayList<EObserver>();
    }

    public void setValue(int value) {
        this.value = value;
        notifyObserver();
    }

    private int value = 0;

    @Override
    public void registerObserver(EObserver o) {
        observerList.add(o);

    }

    @Override
    public void removeObserver(EObserver o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (EObserver eObserver : observerList) {
            eObserver.update(value);
        }

    }
}
