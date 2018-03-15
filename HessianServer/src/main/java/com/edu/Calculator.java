package com.edu;

import com.caucho.hessian.server.HessianServlet;
import edu.f708.Calable;
/*
一个war项目
 */
public class Calculator extends HessianServlet implements Calable {
    @Override
    public int add(int i1, int i2) {
        return i1+i2;
    }

    @Override
    public int multi(int i1, int i2) {
        return i1*i2;
    }
}
