package com.qny.moshMomento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: History.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.moshMomento
 * @Time: 2023/3/10 23:31
 */
public class History {

    private List<EditorState> states= new ArrayList<>();

    public void push(EditorState state){
        states.add(state);
    }

    public EditorState pop(){
        var lastIndex = states.size() - 1;
        var lastState = states.get(lastIndex);
        states.remove(lastState);
        return lastState;

    }
}
