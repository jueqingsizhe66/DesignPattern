package com.f708.listener;

import com.f708.actionResult.ActionResult;
import com.f708.annotation.F708Controller;
import com.f708.core.ControllerMappings;
import com.f708.core.TypeConverterManager;
import com.f708.typeConverter.BooleanConverter;
import com.f708.typeConverter.IntegerConverter;
import com.f708.typeConverter.LongConverter;
import com.f708.typeConverter.StringConverter;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 忘记标了WebListener
 */
@WebListener
public class RPServletContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent e)  {
		
		//从web.xml中获取context-param中名字为rpmvc.package的值
		//只扫描这个包下的类作为controller
		
		// 需要更改这个地方的值
		String f708mvcPakcet = e.getServletContext().getInitParameter("f708mvc.package");
		
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try {
			ClassPath classpath = ClassPath.from(loader);
			//调用guava遍历ClassPath中所有的顶级类
			ImmutableSet<ClassPath.ClassInfo> classes = classpath.getTopLevelClasses(f708mvcPakcet);
			for(ClassPath.ClassInfo clzInfo : classes)
			{
				Class<?> clzController = clzInfo.load();
				F708Controller controllerAnnotation = clzController.getAnnotation(F708Controller.class);
				String clzName = clzController.getSimpleName();
				
				//只有标注RPController的类才作为Controller
				//类必须是public的，并且是非抽象类
				//类名要以Controller结尾
				if(controllerAnnotation!=null&&Modifier.isPublic(clzController.getModifiers())
						&&!Modifier.isAbstract(clzController.getModifiers())
						&&clzName.endsWith("Controller"))
				{
					//截取掉结尾的Controller作为类名
					String controllerName = clzName.substring(0,clzName.length()-"Controller".length());
					
					//获取Controller下所有的public并且返回值为ActionResult类型（或者子类）作为Action方法
					//为了提升反射速度，因此提前把Method缓存起来
					Method[] actionMethods = clzController.getMethods();
					
					//开启注释
					for(Method actionMethod : actionMethods)
					{
						if(!Modifier.isPublic(actionMethod.getModifiers()))
						{
							continue;
						}
						if(!ActionResult.class.isAssignableFrom(actionMethod.getReturnType()))
						{
							continue;
						}
						String actionName = actionMethod.getName();
						
						//断点2
						//注册
						ControllerMappings.getInstance()
								.addAction(controllerName, actionName, actionMethod);
					}
				}
			}
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		
		//注册内置类型转换器
		TypeConverterManager.getInstance().register(boolean.class, new BooleanConverter())
				.register(int.class, new IntegerConverter())
				.register(long.class, new LongConverter())
				.register(String.class, new StringConverter());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	
	}
}
