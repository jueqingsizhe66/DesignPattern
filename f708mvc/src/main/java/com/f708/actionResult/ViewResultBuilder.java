package com.f708.actionResult;

public class ViewResultBuilder {
	private Object model;
	private String viewName;
	private String controllerName;
	
	public Object getModel() {
		return model;
	}
	
	public String getViewName() {
		return viewName;
	}
	
	public String getControllerName() {
		return controllerName;
	}
	
	public ViewResultBuilder model(Object model) {
		this.model = model;
		return this;
	}
	
	public ViewResultBuilder viewName(String viewName) {
		this.viewName = viewName;
		return this;
	}
	
	public ViewResultBuilder controllerName(String controllerName) {
		this.controllerName = controllerName;
		return this;
	}
	
	public ViewResult build() {
		return new ViewResult(this);
	}
}
