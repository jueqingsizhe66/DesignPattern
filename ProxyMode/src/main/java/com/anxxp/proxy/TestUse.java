package com.anxxp.proxy;

/**
 * 控制台的输出就不放上来了，可以看到，代理模式实现确实比较简单，好处也显而易见，将目标对象与使用的用户隔离开，
 * 而且在调用目标对象的方法前后还能执行额外的操作（也会后续的aop的概念做铺垫）。
 */
public class TestUse {
	public static void main(String[] args) {
		AbstractObject obj = new ProxyObject();
		obj.method3();
		obj.method2();
		obj.method1();
	}
}
