package com.qny.bossLeader;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Boss.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.bossLeader
 * @Time: 2023/3/12 13:00
 */
public class Leader extends OAHandler{

    @Override
    public void process(Integer info) {
        if(info > 0 && info <11){
            System.out.println("Leader processed");
        }else{
            /**
             * 至关重要  调用nextHandler
             */
            nextHandler.process(info);

        }

    }
}
