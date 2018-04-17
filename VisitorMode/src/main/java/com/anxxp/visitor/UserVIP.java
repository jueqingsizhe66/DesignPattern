package com.anxxp.visitor;

public class UserVIP implements User {
	String estimate;
	
	public UserVIP(String estimate) {
		this.estimate = estimate;
	}
	
	public String getEstimate() {
		return estimate;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
