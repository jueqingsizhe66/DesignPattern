package com.compu;

import java.io.Closeable;
import java.io.IOException;

/*

适配器：(在改不变所有的情况，到(注意 到最后还是用其他，只不过中间转了一下 AOP也有这种感觉）
 usb电池
 苹果套上盖变android充电线
 HDMI投屏器(同屏转换)

如果需要将“一些现存的对象”放在新的环境中应用，但是新环境要求的接口是这些现存对象所不满足的。那么就可以创建一个适配器让旧对象适用于新环境。



 */
public class ComputerAdapter implements Closeable {
    private Computer comp;
    public ComputerAdapter(Computer c)
    {
        this.comp = c;
    }
    @Override
    public void close() throws IOException {
        //还是Computer类的close() 方法
        comp.close();
    }
}
