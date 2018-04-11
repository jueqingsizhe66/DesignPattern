package com.anxxp.proxy;

public class TargetObject implements AbstractObject {
	@Override
	public void method1() {
		System.out.println("hello 1");
	}
	
	@Override
	public int method2() {
		System.out.println("hello 2");
		return 0;
	}
	
	@Override
	public void method3() {
		
		System.out.println("hello 3");
	}
}
