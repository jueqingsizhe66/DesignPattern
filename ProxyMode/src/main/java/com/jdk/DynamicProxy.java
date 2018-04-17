package com.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
	
	/**
	 * 需要代理的目标对象
	 */
	private Object target;
	
	/**
	 * 写法固定，aop专用:绑定委托对象并返回一个代理类
	 */
	public Object bind(Object target) {
		this.target = target;
        /*
        第二个参数代理类要实现社么接口
        第三个 当调用方法的时候调用那个对象的invoke方法。

        newProxyInstance创建了 com.sun.proxy.$PROXY()对象

        class $Proxy() implements ITest
        {
         private InvocationHandler handler;
         publci $Proxy(InvocationHandler hander){
         this.handler =handler;

         }
         public static Object newProxyInstance(...){
         ...
         }
         public void test1(){
          Class clz =ITest.class;
          Method method = clz.getMethod("test1);
          handler.invoke(this.method);
         }
          public void test2(String s){
          Class clz =ITest.class;
          Method method = clz.getMethod("test2);
          handler.invoke(this.method,s);
         }
        }
         */
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this); //this当前对象
	}
	
	/**
	 * @param Object target：指被代理的对象。
	 * @param Method method：要调用的方法
	 * @param Object [] args：方法调用时所需要的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getName() + "执行之前");
		
		//if(method == ITest.class.getMethod("test2",String.class))
		if (method.equals(ITest.class.getMethod("test2", String.class))) {
			String s = (String) args[0];
			if (s.contains("xi")) {
				throw new IllegalArgumentException("parameter cannot contain xi!!!!!!!!");
			}
		}
		Object result = method.invoke(target, args);//执行目标方法 调用目标对象（被代理的国外网站）
		System.out.println(method.getName() + "执行之后");
		return result;
	}
	
}
