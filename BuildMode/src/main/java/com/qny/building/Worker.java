package com.qny.building;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Worker.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.building
 * @Time: 2023/3/12 18:11
 */
public class Worker extends Builder{
    //具体的工人完成一个产品
    private Product product;

    public Worker() {
        // 不是通过参数带入的，而是直接通过new带入对象
        this.product = new Product();
    }

    @Override
    void buildA() {
        product.setBuildA("地基");
        System.out.println("地基完毕");
    }

    @Override
    void buildB() {
        product.setBuildB("钢筋工程");
        System.out.println("钢筋工程完成");

    }

    @Override
    void buildC() {
        product.setBuildC("铺电线");
        System.out.println("铺电线完成");

    }

    @Override
    void buildD() {
        product.setBuildD("粉刷");
        System.out.println("粉刷完成");

    }

    @Override
    Product getProduct() {
        return product;
    }
}
