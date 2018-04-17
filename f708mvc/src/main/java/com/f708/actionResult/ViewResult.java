package com.f708.actionResult;

import com.f708.core.ControllerContext;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * * 渲染和Controller同名的视图
 * 视图是和当前Controller名字一样的Web-Inf下的文件夹下的viewName一样的jsp文件夹
 * 如果viewName为null，则为当前的Action的名字
 * model是传递给视图的数据
 */
public class ViewResult implements ActionResult {
	private Object model;
	private String viewName;
	private String controllerName;
	
	public ViewResult(ViewResultBuilder builder) {
		this.model = builder.getModel();
		this.viewName = builder.getViewName();
		this.controllerName = builder.getControllerName();
	}
	
	
	@Override
	public void execute(ControllerContext context) throws IOException {
		//如果viewName为null，则为当前的Action的名字
		if (viewName == null) {
			viewName = context.getActionName();
		}
		//如果controllerName为null，则为当前的Controller的名字
		if (controllerName == null) {
			controllerName = context.getControllerName();
		}
		//jsp视图路径
		String jspPath = "/WEB-INF/" + controllerName + "/" + viewName + ".jsp";
		try {
			//把model放到request中
			context.getRequest().setAttribute("model", model);
			context.getRequest().getRequestDispatcher(jspPath)
					.forward(context.getRequest(), context.getResponse());
		} catch (ServletException e) {
			throw new IOException(e);
		}
	}
}
