package com.cglib;

public class TestImpa {
	/*
	不能使final方法
	 */
	public void test1() {
		System.out.println("父类代理--test1");
	}
	
	public void test2(String s) {
		System.out.println("父类代理--" + s);
	}
	
}
