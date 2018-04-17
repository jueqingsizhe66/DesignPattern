package com.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
	private Object target; //被代理对象
	
	/**
	 * 创建代理对象
	 *
	 * @param target
	 * @return
	 */
	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
        /*
        调用父类方法，这是有点不一样
        不能是final方法（只能是虚方法 ，可继承）
         */
		enhancer.setSuperclass(this.target.getClass());
		// 回调方法
		enhancer.setCallback(this);
		// 创建代理对象
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println(method.getName() + "方法开始之前");
        /*
        一定得传对参数
         */
		Object result = methodProxy.invokeSuper(proxy, args);//调用目标方法
		System.out.println(method.getName() + "方法开始之后");
		return result;
		
	}
}
