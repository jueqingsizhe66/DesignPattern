package com.qny.rent;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Client.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.rent
 * @Time: 2023/3/12 23:26
 */
public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        host.rent();

        //新方法
        Host host2=  new Host();
        Lianjia lianjia = new Lianjia(host2); //代理一般有附属操作，收取费用是最重要的
        lianjia.rent();
    }
}
