package com.qny.computer;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Computer.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.computer
 * @Time: 2023/3/12 16:47
 */
public abstract class Computer {
    //不要用继承 就使用组合模式  带入品牌字段
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

   public void info(){
        brand.info();
   }
}
