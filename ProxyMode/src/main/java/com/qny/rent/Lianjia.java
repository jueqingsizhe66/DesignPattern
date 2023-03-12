package com.qny.rent;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Lianjia.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.rent
 * @Time: 2023/3/12 23:27
 */
public class Lianjia implements Rent{
    private Host host;

    public Lianjia(){

    }
    public Lianjia(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        visitHouse(); //中介额外功能
        host.rent(); // 中介调用host的租房
        contract();// 中介签合同
        fare();//收取中介费
    }

    /**
     * 中介可以看房
     */
    public void visitHouse(){
        System.out.println("中介带你看房");
    }

    /**
     * 收中介费
     */
    public void fare(){
        System.out.println("收中介费");
    }

    /**
     * 租赁合同
     */
    public void contract(){
        System.out.println("中介签署合同");
    }

}
