package proxy;

import proxy.annotation.AnnoInjection;
import proxy.aop.AOPMethod;
import proxy.aop.AOPNewHandle;

import java.lang.reflect.Proxy;

public class AnimalFactorAnnoNew {
	private static Object getAnimalBase(Object obj, AOPMethod method) {
		//get proxy object
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new AOPNewHandle(AnnoInjection.getBean(obj), method));
	}

	@SuppressWarnings("unchecked")
	public static <T> T getAnimial(Object obj, AOPMethod method) {
		return (T) getAnimalBase(obj, method);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getAnimal(String className, AOPMethod method) {
		Object obj = null;
		try {
			obj = getAnimalBase(Class.forName(className).newInstance(), method);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) obj;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getAnimal(Class clz, AOPMethod aop) {
		Object obj = null;
		try {
			obj = getAnimalBase(clz.newInstance(), aop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) obj;
	}

}
