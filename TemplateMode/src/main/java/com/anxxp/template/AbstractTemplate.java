package com.anxxp.template;

public abstract class AbstractTemplate {
	Object data;
	
	/**
	 * 系列模板方法
	 */
	
	void dealData() {
		getData();
		calcData();
		printData();
	}
	
	/**
	 * 普通方法，可以实现 也可能需要子类实现
	 */
	void printData(){
		System.out.println(data);
	};
	
	abstract void calcData();
	
	abstract void getData();
}
