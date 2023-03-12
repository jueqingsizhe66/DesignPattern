package com.qny.FactoryMethod;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: CarFactory.java
 * @Description: 简单工厂模式也叫做静态工厂模式(因为static Car类型)   不方便拓展， 新加入一种车型 else if 必须新增 ，破坏了开闭原则
 * 当然如果car比较少，其实简单工厂模式也比较简单，因为简单  所以用的人也比较多！
 * 如果使用工厂方法，来替代简单工厂模式， 代价会比较大！
 * @Package com.qny.SimpleFactory
 * @Time: 2023/3/12 23:00
 */
public interface CarFactory {
     Car getCar();
}
