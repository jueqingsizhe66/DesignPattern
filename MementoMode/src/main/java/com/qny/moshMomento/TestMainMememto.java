package com.qny.moshMomento;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: TestMainMememto.java
 * @Description: (用一句话描述该文件做什么 ?) https://www.youtube.com/watch?v=NU_1StN5Tkk
 * @Package com.qny.moshMomento
 * @Time: 2023/3/10 23:37
 */
public class TestMainMememto {
    public static void main(String[] args) {
        var editor = new Editor();
        var history = new History();

        /**
         * 原先的写法。没有中间过程  直接覆盖
         */
        editor.setContent("apple");
        editor.setContent("banana");
        editor.setContent("orange");
        editor.setContent("juice");
        /**
         * 现在的写法
         */
        editor.setContent("apple");
        history.push(editor.createEditorState());
        editor.setContent("banana");
        history.push(editor.createEditorState());
        editor.setContent("orange");
        history.push(editor.createEditorState());
        editor.setContent("juice");
        history.push(editor.createEditorState());
        editor.restoreState(history.pop());
        System.out.println(editor.getContent()); /*should be juice*/
        System.out.println(editor.getContent().equals("orange")); /*false*/
        editor.restoreState(history.pop());
        System.out.println(editor.getContent()); /*should be orange*/
        System.out.println(editor.getContent().equals("orange")); /*true*/
    }
}
