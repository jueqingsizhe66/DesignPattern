package com.qny.bossLeader;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: OAHandler.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.bossLeader
 * @Time: 2023/3/12 12:58
 */
public abstract class OAHandler {
    protected OAHandler nextHandler; //至关重要， 后面的子类继承会使用到  特别是leader类

    public void setHandler(OAHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * boss 10级以上
     * leader 1-10级
     * @param info
     */
    public abstract void process(Integer info);

}
