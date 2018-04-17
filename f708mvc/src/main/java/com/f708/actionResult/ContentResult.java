package com.f708.actionResult;

import com.f708.core.ControllerContext;

import javax.servlet.ServletResponse;
import java.io.IOException;

public class ContentResult implements ActionResult {
	private String content;
	
	private String contentType;
	
	public ContentResult(String content) {
		super();
		this.content = content;
		this.contentType = "text/html";
	}
	
	
	public String getContent() {
		return content;
	}
	
	
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public String getContentType() {
		return contentType;
	}
	
	
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	
	@Override
	public void execute(ControllerContext context) throws IOException {
		ServletResponse response = context.getResponse();
		response.setContentType(this.contentType);
		response.getWriter().print(this.content);
	}
}
