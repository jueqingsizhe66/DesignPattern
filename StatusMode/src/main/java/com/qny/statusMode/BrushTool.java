package com.qny.statusMode;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: BrushTool.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.statusMode
 * @Time: 2023/3/10 23:01
 */
public class BrushTool implements ToolInter{
    @Override
    public void mouseUp() {
        System.out.println("BrushToolUp");
    }

    @Override
    public void mouseDown() {
        System.out.println("BrushToolDown");
    }
}
