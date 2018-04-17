package com.f708.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerContext {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String controllerName;
	private String actionName;
	
	public HttpServletRequest getRequest() {
		return request;
	}
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public HttpServletResponse getResponse() {
		return response;
	}
	
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public String getControllerName() {
		return controllerName;
	}
	
	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}
	
	public String getActionName() {
		return actionName;
	}
	
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
}
