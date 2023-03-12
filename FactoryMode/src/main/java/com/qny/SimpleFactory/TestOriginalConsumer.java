package com.qny.SimpleFactory;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: TestOriginalConsumer.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.SimpleFactory
 * @Time: 2023/3/12 22:58
 */
public class TestOriginalConsumer {
    public static void main(String[] args) {
        /**
         * 原来消费者访问模式
         */
        Car wuling = new Wulingzhiguang();
        Car tesla = new Tesla();
        wuling.name();
        tesla.name();

        //可不可以不用new来创建？ 为什么不用 new？  需要管有多少种车  其实直接把车注册到工厂即可
        // 新的方式来获取Car
        Car wuling2 = CarFactory.getCar("五菱");
        Car tesla2 = CarFactory.getCar("特斯拉");
        wuling2.name();
        tesla2.name();

    }
}
