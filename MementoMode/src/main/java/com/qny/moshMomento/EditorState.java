package com.qny.moshMomento;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: EditorState.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.moshMomento
 * @Time: 2023/3/10 23:26
 */
public class EditorState {
    public String getContent() {
        return content;
    }

    /**
     * if initial ,content cannot be modified
     */
    private final String content;

    public EditorState(String content) {
        this.content = content;
    }
}
