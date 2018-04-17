package com.anxxp.BuildMode;

/**
 * 使用不同生成器，可以使原有产品表现得有点不一样。
 * <p>
 * 往往在实际的应用中，生成器要做的工作不会这么简单，而是相对复杂的（因为其产品一般是比较复杂的），原有构建的维护会转移到生成器的维护上。
 */
public class TestUse {
	public static void main(String[] args) {
		MyDate date = new MyDate();
		IDateBuilder builder;
		builder = new DateBuilderApple(date).buildDate(2066, 3, 5);
		System.out.println(builder.date());
		builder = new DateBuilderBanana(date).buildDate(2066, 3, 5);
		System.out.println(builder.date());
	}
}
