package com.f708.actionResult;

import com.f708.core.ControllerContext;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletResponse;
import java.io.IOException;

public class AjaxResult implements ActionResult {
	private Object data;
	
	/**
	 * @param data ajax数据
	 */
	public AjaxResult(Object data) {
		super();
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public void execute(ControllerContext context) throws IOException {
		ServletResponse response = context.getResponse();
		
		response.setContentType("application/json");
		GsonBuilder builder = new GsonBuilder();
		//用gson把对象转换为json
		String json = builder.create().toJson(data);
		response.getWriter().print(json);
	}
}
