package com.qny.Strategic;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: CityDuck.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.Strategic
 * @Time: 2023/3/11 0:49
 */
public class CityDuck extends Duck{
    public CityDuck() {
        super();
        setFl(new SimpleFlying());;
        setQu(new FunnyQuack());
    }
    public void display(){
        System.out.println("City Duck Display");
    }

}
