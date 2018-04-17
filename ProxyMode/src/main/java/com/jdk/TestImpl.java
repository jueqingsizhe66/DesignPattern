package com.jdk;

public class TestImpl implements ITest {
	@Override
	public void test1() {
		System.out.println("真正的国外网站---test1");
	}
	
	@Override
	public void test2(String s) {
		System.out.println("真正的国外网站" + s);
	}
}
