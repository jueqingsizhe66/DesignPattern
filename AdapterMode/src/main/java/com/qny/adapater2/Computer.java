package com.qny.adapater2;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Computer.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.adapater2
 * @Time: 2023/3/12 17:07
 */

/**
 * 客户端类 需要插入网线上网，， 但是客户端插不上网线口，只有usb口
 */
public class Computer {
    //电脑需要上网的话  需要买无线网卡
   public void net(NetToUSB adapter){
        adapter.handleRequest();
   }

    public static void main(String[] args) {
        System.out.println("方式一： 类适配器 by 继承");
        Computer c1 = new Computer(); //电脑, 通过类适配器（也就是AdapterWuXianWangka)进行上网
        Adaptee adaptee = new Adaptee(); //网线
        AdapterWuXianWangKa wuxianwangka = new AdapterWuXianWangKa(); // 无线网卡

        c1.net(wuxianwangka);


        System.out.println("方式二： 对象适配器 by 组合");
        Computer c2 = new Computer();// 通过对象适配器,也就是AdapterCompositor 内置Adaptee上网功能， 内置该对象变量
        AdapterComposite adapterComposite = new AdapterComposite(adaptee); // 可以热插拔不同的网线
        c2.net(adapterComposite);

    }
}
