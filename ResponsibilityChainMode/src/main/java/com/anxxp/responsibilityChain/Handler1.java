package com.anxxp.responsibilityChain;

public class Handler1 implements Handler {
	private Handler next;
	
	@Override
	public int handleRequest(int n) {
		if (n < 0) {
			System.out.println("handle1");
			return -n;
		} else {
			if (next == null)
				throw new NullPointerException("next 不能为空");
			return next.handleRequest(n);
		}
	}
	
	@Override
	public void setNextHandler(Handler next) {
		this.next = next;
	}
}
