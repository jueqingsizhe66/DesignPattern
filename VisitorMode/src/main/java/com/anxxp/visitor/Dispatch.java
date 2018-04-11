package com.anxxp.visitor;

public class Dispatch {
	/**
	 * 根据参数类型进行调用
	 * @param c
	 */
	void print(FatherClass c) {
		System.out.println("Dispatch: FatherClass");
	}
	
	void print(ChildClass c) {
		System.out.println("Dipatch:Child Class");
	}
	
	public static void main(String[] args) {
		FatherClass child = new ChildClass();
		new Dispatch().print(child);
		/**
		 * 根据接受者进行调用
		 */
		child.print();
		
	}
}
class FatherClass{
	void print() {
		System.out.println("Father class");
	}
}
class ChildClass extends FatherClass{
	void print() {
		System.out.println("Child class");
	}
}
