package com.anxxp.visitor;

public class UserOrdinary implements User {
	public String getEstimation() {
		return estimation;
	}
	
	String estimation;
	
	public UserOrdinary(String estimation) {
		this.estimation = estimation;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
/**
 * //这个就是重点，第一次分派是调用accept()方法时根据接收者的实际类型来调用的【對象的動態分配】，第二次分派就是通过visitor.visit(this)，
 * 传入静态类型【方法參數的靜態分配，依然是刪除、增加等功能函數，因為本身也不需要變】，然后再visit()方法中反过来调用this本身的方法。
 */
	}
}
