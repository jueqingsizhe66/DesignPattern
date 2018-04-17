package com.anxxp.responsibilityChain;

public interface Handler {
	int handleRequest(int n);
	
	void setNextHandler(Handler next);
}
