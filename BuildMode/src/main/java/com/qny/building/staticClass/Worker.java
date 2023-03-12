package com.qny.building.staticClass;


/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Worker.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.building.staticClass
 * @Time: 2023/3/12 18:27
 */
//具体的建造者 （主机厂家） 海装 东气
public class Worker extends Builder{

    private Product product;

    // 必须得有构造者函数 否则范围空
    public Worker() {
        // 这句话很关键  建造者函数都带一个午餐构造函数， 初始化private产品字段
        // 不然this.product 无法被初始化
        this.product = new Product();
    }

    @Override
    Builder buildA(String msg) {
        product.setBuildA(msg);
        // return是worker对象
        return this;
    }

    @Override
    Builder buildB(String msg) {
        product.setBuildB(msg);
        return this;
    }

    @Override
    Builder buildC(String msg) {
        product.setBuildC(msg);
        return this;
    }

    @Override
    Builder buildD(String msg) {
        product.setBuildD(msg);
        return this;
    }

    @Override
    Product getProduct() {
        return product;
    }
}
