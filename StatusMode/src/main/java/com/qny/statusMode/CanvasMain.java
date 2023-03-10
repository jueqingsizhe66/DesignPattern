package com.qny.statusMode;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: CanvasMain.java
 * @Description: (用一句话描述该文件做什么 ?)https://www.youtube.com/watch?v=NU_1StN5Tkk
 * @Package com.qny.statusMode
 * @Time: 2023/3/10 23:03
 */
public class CanvasMain {
    public static void main(String[] args) {
        CanvasPic canvas = new CanvasPic();
//        canvas.setCurrentToool(new BrushTool());
        canvas.setCurrentToool(new RenDerTool());
        canvas.mouseDown();
        canvas.mouseUp();
    }
}
