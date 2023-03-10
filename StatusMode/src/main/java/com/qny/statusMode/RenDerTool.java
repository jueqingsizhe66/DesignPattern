package com.qny.statusMode;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: RenDerTool.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.statusMode
 * @Time: 2023/3/10 23:02
 */
public class RenDerTool implements ToolInter {
    @Override
    public void mouseUp() {
        System.out.println("RenderToolUp");
    }

    @Override
    public void mouseDown() {
        System.out.println("RenderToolDown");

    }
}
