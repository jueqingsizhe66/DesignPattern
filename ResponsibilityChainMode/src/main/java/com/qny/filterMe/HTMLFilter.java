package com.qny.filterMe;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: HTMLFilter.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.filterMe
 * @Time: 2023/3/13 23:29
 */
public class HTMLFilter implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace('<', '[');
        r = r.replace('>', ']');
        m.setMsg(r);
        return true;
    }
}
