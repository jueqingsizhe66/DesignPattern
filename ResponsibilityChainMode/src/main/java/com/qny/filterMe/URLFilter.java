package com.qny.filterMe;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: URLFilter.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.filterMe
 * @Time: 2023/3/13 23:30
 */
public class URLFilter implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        String r = m.getMsg();
        r = r.replace("qny.com", "http://www.qny.com");
        m.setMsg(r);
        return true;
    }
}
