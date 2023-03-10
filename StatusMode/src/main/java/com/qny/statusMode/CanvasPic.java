package com.qny.statusMode;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: CanvasPic.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.statusMode
 * @Time: 2023/3/10 23:04
 */
public class CanvasPic {
    private ToolInter currentToool;
    public ToolInter getCurrentToool() {
        return currentToool;
    }
    public void mouseUp(){
        currentToool.mouseUp();
    }
    public  void mouseDown(){
        currentToool.mouseDown();
    }

    public void setCurrentToool(ToolInter currentToool) {
        this.currentToool = currentToool;
    }


}
