package com.f708.core;

import com.f708.actionResult.ActionResult;
import com.f708.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 忘记标了WebServlet
 */
//@WebServlet  所有/的都由DispatcherServlet处理
@WebServlet("/")
public class DispatcherServlet  extends HttpServlet {

	/**
	 * 获取请求参数名
	 * @param parameter
	 * @return
	 */
	private static String getParamterName(Parameter parameter)
	{
		RequestParam reqParam = parameter.getAnnotation(RequestParam.class);
		//如果设定了@RequestParam 注解，则用RequestParam注解的值作为参数名
		//如果没设定则用参数名，由于低版本JDK编译后class中不保留参数名
		// parameter.getName()获取的都是arg0、arg1，因此需要配置“JDK8新特性:编译器保留方法参数名字”
		if(reqParam==null)
		{
			return parameter.getName();
		}
		else
		{
			return reqParam.value();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//URL格式：/Controller名字/Action名字
		Pattern patternUrl = Pattern.compile("/(.+?)/(.+)");
		Matcher matcher =  patternUrl.matcher(request.getServletPath());
		if(!matcher.find())//如果没有找到则404
		{
			response.sendError(404);
			return;
		}
		//解析出Controller和Action的名字
		String controllerName = matcher.group(1);
		String actionName = matcher.group(2);
		
		//获取Action对应的方法名
		Method actionMethod = ControllerMappings.getInstance().getAction(controllerName, actionName);
		if(actionMethod==null)
		{
			response.sendError(404, "cannot find controller="+controllerName+",actionName="+actionName);
			return;
		}
		
		//获取方法所在的类名，也就是Controller的名字
		Class<?> controllerClz = actionMethod.getDeclaringClass();
		try {
			Object controllerObject = controllerClz.newInstance();//创建Controller类对象
			
			//获取Action参数
			Parameter [] methodParameters = actionMethod.getParameters();
			
			//调用Action参数的值
			Object[] parameterValues = new Object[methodParameters.length];
			for(int i=0;i<methodParameters.length;i++)
			{
				Parameter parameter = methodParameters[i];
				String parameterName = getParamterName(parameter);//获取参数名
				//在Eclipse的Java compiler中勾选【store information about method parameters】
				String parameterValue = request.getParameter(parameterName);
				
				//把请求报文中的字符串类型的值转换为对应的方法参数类型值
				parameterValues[i] = TypeConverterManager.getInstance()
						.convert(parameter.getType(), parameterValue);
			}
			//调用Action方法
			ActionResult actionResult = (ActionResult)actionMethod.invoke(controllerObject, parameterValues);
			
			//执行方法返回的ActionResult
			ControllerContext mvcCtx = new ControllerContext();
			mvcCtx.setActionName(actionName);
			mvcCtx.setControllerName(controllerName);
			mvcCtx.setRequest(request);
			mvcCtx.setResponse(response);
			actionResult.execute(mvcCtx);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
