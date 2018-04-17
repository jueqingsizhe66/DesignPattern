package proxy.aop;

import java.lang.reflect.Method;

// 体现面向AOP变编程的接口
/*
首先增加一个接口,咱们就称为AOP注入接口吧.取名AOPMethod哈
创建after和before方法,接收Object proxy, Method method, Object[] args参数
这样就能做更多的事情叻…比如执行方法前,记录类状态,写入log.监控xx变量,,,
开启你的脑洞吧.
 */
public interface AOPMethod {

	// 实例方法执行前执行的方法
	void after(Object proxy, Method method, Object[] args);

	// 实例方法执行后执行的方法
	void before(Object proxy, Method method, Object[] args);
}
