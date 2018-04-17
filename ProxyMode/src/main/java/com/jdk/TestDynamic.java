package com.jdk;

public class TestDynamic {
	public static void main(String[] args) {
		TestImpl test = new TestImpl();
		ITest itest1 = (ITest) new DynamicProxy().bind(test);
		
		itest1.test1();
		itest1.test2("hello");
		itest1.test2("hello xi");
	}
}
