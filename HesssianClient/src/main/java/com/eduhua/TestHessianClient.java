package com.eduhua;

import com.caucho.hessian.client.HessianProxyFactory;
import edu.f708.Calable;

import java.net.MalformedURLException;

public class TestHessianClient {
    public static void main(String[] args) throws MalformedURLException {
        String url = "http://localhost:8082/calc";
        /*
        如何看请求相应的报文？？？

        很多开源框架，都有开关可以打开 fac.setDebug(true) ...

         */
        HessianProxyFactory factory = new HessianProxyFactory();
        Calable basic = (Calable)factory.create(Calable.class, url);
        System.out.println(basic.add(1, 2));
        System.out.println(basic.multi(30, 5));

        /*
       interface edu.f708.Calable
        interface com.caucho.hessian.io.HessianRemoteObject
         */
        for (Class<?> clz : basic.getClass().getInterfaces()) {
            System.out.println(clz);
        }

    }
}
