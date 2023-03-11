package com.qny.pizza;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Pizza.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.pizza
 * @Time: 2023/3/11 23:39
 */
public abstract class Pizza {
    public String getDescription() {
        return description;
    }

    /**
     * 不能是private 否则其他类无法访问
     */
     String description  = "Basic Pizza";

    public abstract double cost();
}
