package com.f708.actionResult;

import com.f708.core.ControllerContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectResult implements ActionResult {
	private String location;
	
	public RedirectResult(String location) {
		super();
		this.location = location;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public void execute(ControllerContext context) throws IOException {
		HttpServletResponse httpResp = context.getResponse();
		httpResp.sendRedirect(location);
	}
}
