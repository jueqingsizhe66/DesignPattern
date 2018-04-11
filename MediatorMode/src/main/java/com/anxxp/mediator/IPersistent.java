package com.anxxp.mediator;

//同事
public interface IPersistent {
    void getData(Object data);
    void getData(Object data,Midiator midiator);
    void saveData();
}
