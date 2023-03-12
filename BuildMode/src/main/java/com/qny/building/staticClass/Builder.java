package com.qny.building.staticClass;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Builder.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.building.staticClass
 * @Time: 2023/3/12 18:23
 */
//所有主机厂家的鼻祖
public abstract class Builder {
    // 用户可以设置自己喜欢的类型，一般是同一类型（差别太大不好，比如牛排和薯条不放在一起，不然代价就太大）
    abstract Builder buildA(String msg); //汉堡
    abstract Builder buildB(String msg); //可乐
    abstract Builder buildC(String msg); //薯条
    abstract Builder buildD(String msg);// 甜点
    //返回的都是Builder类

    //必须有这个类
    abstract Product getProduct();

}
