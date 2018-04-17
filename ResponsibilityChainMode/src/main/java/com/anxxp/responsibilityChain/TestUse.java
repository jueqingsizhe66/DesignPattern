package com.anxxp.responsibilityChain;

/**
 * 此处责任链中的具体处理者的顺序是不能重设的，否则可能会引发错误，但更多的情况是完全可以随意更改他们的位置的，
 * 就上例中，只要把if中的条件重新设置（各自独立，不相互依赖），就可以了。
 * <p>
 * 我们写java web程序的时候，通常会编写一些过滤器（Filter），然后配置到web.xml中，这其实就是责任链模式的一种实践。
 * 而使用Log4j记录日志，配置级别的时候，也同样用到了责任链模式。
 * <p>
 * 我们使用责任链模式的时候，不一定非得某一处理者处理后就得终止请求的传递，如果有其他需求，我们依然可以继续传递这
 * 个请求到下一个具体的处理者。
 */
public class TestUse {
	public static void main(String[] args) {
		Handler h1, h2, h3;
		h1 = new Handler1();
		h2 = new Handler2();
		h3 = new Handler3();
		h1.setNextHandler(h2);
		h2.setNextHandler(h3);
		System.out.println(h1.handleRequest(-1));
		System.out.println(h1.handleRequest(5));
		System.out.println(h1.handleRequest(9999));
	}
}
