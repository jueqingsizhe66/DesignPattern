package com.qny.bossLeader;

import com.anxxp.responsibilityChain.Handler;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: TestChainOfResponsibility.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.bossLeader
 * @Time: 2023/3/12 13:02
 */
public class TestChainOfResponsibility {
    public static void main(String[] args) {
        OAHandler boss = new Boss();
        OAHandler leader = new Leader();

        //Leader 是第一个节点
        leader.setHandler(boss); //boss的下一层级是leader
        // 从小 往大进行处理
        leader.process(11);
        leader.process(10);
        leader.process(20);
        leader.process(30);
    }
}
