package com.qny.building;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: TestDirectorAndWorker.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.building
 * @Time: 2023/3/12 18:17
 */
public class TestDirectorAndWorker {
    public static void main(String[] args) {
        Director director = new Director();
        // 换不同worker 可能出来的building就会有所不同了
        Product buildProduct = director.build(new Worker());
        System.out.println(buildProduct);

    }
}
