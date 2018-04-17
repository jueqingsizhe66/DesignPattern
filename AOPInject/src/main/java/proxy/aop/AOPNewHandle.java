package proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AOPNewHandle implements InvocationHandler {
	// 保存对象
	private AOPMethod method;
	private Object o;

	public AOPNewHandle(Object o, AOPMethod method) {
		this.o = o;
		this.method = method;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//方法返回值
		Object ret = null;
		//打印方法名称
		this.method.before(proxy, method, args);
		ret = method.invoke(o, args);
		this.method.after(proxy, method, args);
		//返回反射调用方法的返回值
		return ret;
	}

}
