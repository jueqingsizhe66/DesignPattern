package com.qny.filterMe;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: TestChianFilter.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.filterMe
 * @Time: 2023/3/13 23:35
 */
public class TestChianFilter {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)，<script>，欢迎访问 qny.com ，大家都是996 ");
        FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter())
                .add(new SensitiveFilter());
        // 如果SensitevieFilter设置为return false,那么下面的filter直接返回（只要一个为false， 那么直接返回，经典but操作）

        FilterChain fc2 = new FilterChain();
        fc2.add(new FaceFilter())
                .add(new URLFilter());

        fc.add(fc2);
        fc.doFilter(msg);
        System.out.println(msg);

    }
}
