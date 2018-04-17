package com.f708.core;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * 管理Controller/Action和Action方法Method的对应关系
 */
public class ControllerMappings {
	private static ControllerMappings instance = new ControllerMappings();
	
	public static ControllerMappings getInstance()
	{
		return instance;
	}
	
	private ControllerMappings()
	{
	
	}
	
	
	private HashMap<String, Method> actionMappings = new HashMap<>();
	
	/**
	 * 注册
	 * @param controllerName
	 * @param actionName
	 * @param actionMethod action方法
	 */
	public void addAction(String controllerName,String actionName,Method actionMethod)
	{
		actionMappings.put("/"+controllerName+"/"+actionName, actionMethod);
	}
	
	/**
	 * 获取controller名字为controllerName，action名字为actionName对应的方法的Method
	 * @param controllerName
	 * @param actionName
	 * @return
	 */
	public Method getAction(String controllerName,String actionName)
	{
		return actionMappings.get("/"+controllerName+"/"+actionName);
	}
}
