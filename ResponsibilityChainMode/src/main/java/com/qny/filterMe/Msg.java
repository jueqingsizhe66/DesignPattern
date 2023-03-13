package com.qny.filterMe;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Msg.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.filterMe
 * @Time: 2023/3/13 23:27
 */
public class Msg {
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
