package com.qny.moshMomento;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Editor.java
 * @Description: (用一句话描述该文件做什么 ?https://www.youtube.com/watch?v=NU_1StN5Tkk)
 * @Package com.qny.moshMomento
 * @Time: 2023/3/10 23:26
 */
public class Editor {
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;


    public EditorState createEditorState(){
        return new EditorState(content);
    }

    public void restoreState(EditorState state){
        content= state.getContent();
    }
}
