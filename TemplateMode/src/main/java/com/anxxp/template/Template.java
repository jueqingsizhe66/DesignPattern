package com.anxxp.template;

public class Template extends AbstractTemplate {
	
	@Override
	void calcData() {
		data = (String) data + data;
	}
	
	@Override
	void getData() {
		data = "data";
	}
}
