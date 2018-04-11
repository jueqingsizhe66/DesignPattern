package com.anxxp.visitor;


public class MultiDispatch {
	public static void main(String[] args) {
		Son son = new Son();
		/**
		 * 接收者动态分派
		 */
		son.print();
		/**
		 * 参数动态分派
		 */
		son.print(new Visitor2());
		
	}
}

class Father{
	void print() {
		System.out.println("Father Class");
	}
}

class Son extends Father{
	void print() {
		System.out.println("Son Class");
	}
	
	void print(Visitor2 c) {
		c.print(this);
	}
}

class Visitor2{
	public void print (Son son)
	{
		son.print();
	}
}
