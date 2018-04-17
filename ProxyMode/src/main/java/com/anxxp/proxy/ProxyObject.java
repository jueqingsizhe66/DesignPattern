package com.anxxp.proxy;

public class ProxyObject implements AbstractObject {
	AbstractObject ob = new TargetObject();
	
	@Override
	public void method1() {
		ob.method1();
	}
	
	@Override
	public int method2() {
		return ob.method2();
	}
	
	@Override
	public void method3() {
		System.out.println("调用目标前操作");
		ob.method3();
		System.out.println("调用目标后操作");
	}
}
