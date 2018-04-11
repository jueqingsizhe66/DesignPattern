package com.anxxp.responsibilityChain;

public class Handler3 implements Handler {
	private Handler next;
	@Override
	public int handleRequest(int n) {
		if(n<=Integer.MAX_VALUE) {
			System.out.println("Handler3");
			return n;
		} else{
			if(next==null)
				throw new NullPointerException("next 不能为空");
			return next.handleRequest(n);
		}
	}
	@Override
	public void setNextHandler(Handler next) {
		this.next = next;
	}
}
