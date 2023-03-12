package com.qny.building.staticClass;


/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: TestStaticMethodWorker.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.building.staticClass
 * @Time: 2023/3/12 18:30
 */
public class TestStaticMethodWorker {
    public static void main(String[] args) {

        Worker worker = new Worker();
        Product product = worker.getProduct();
        System.out.println(product);

        //链式编程自定义工具
        Product productLinks = worker.buildA("全家桶").buildB("雪菜").getProduct();
        System.out.println(productLinks);
    }
}
