package com.qny.building.windTurbine;


/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: WindTurbine.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.building.staticClass
 * @Time: 2023/3/12 18:23
 */
//所有主机厂家的鼻祖
public abstract class WindTurbineFactory {
    // 用户可以设置自己喜欢的类型，一般是同一类型（差别太大不好，比如牛排和薯条不放在一起，不然代价就太大）
    abstract WindTurbineFactory buildBlade(String msg); //叶片
    abstract WindTurbineFactory buildMainBearing(String msg); //主轴承
    abstract WindTurbineFactory buildGearBox(String msg); //齿轮箱
    abstract WindTurbineFactory buildGenerator(String msg);// 发电机
    abstract WindTurbineFactory buildPLC(String msg);// PLC
    //返回的都是Builder类

    //必须有这个类
    abstract WindTurbine getProduct();

}
