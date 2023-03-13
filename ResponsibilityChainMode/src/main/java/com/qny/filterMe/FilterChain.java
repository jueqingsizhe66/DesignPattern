package com.qny.filterMe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: FilterChain.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.filterMe
 * @Time: 2023/3/13 23:31
 */
public class FilterChain implements Filter{
    private List<Filter> filterList = new ArrayList<Filter>();
    public FilterChain add(Filter f){
        filterList.add(f);
        return this; //建造者模式？
        /**
             @Override
             Builder buildA(String msg) {
                 product.setBuildA(msg);
                 // return是worker对象
                 return this;
             }
         *
         */
    }
    @Override
    public boolean doFilter(Msg m) {
        for (Filter filter : filterList) {
            //少一个非操作出现问题
            if(!filter.doFilter(m)){
                return false;
            }
        }
        return true;
    }
}
