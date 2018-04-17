package com.anxxp.flyweight;

/**
 * 享元模式的优点在于它大幅度地降低内存中对象的数量。但是，它做到这一点所付出的代价也是很高的：享元模式使得系统更加复杂。为了使对象可以共享，需要将一些状态外部化，这使得程序的逻辑复杂化。享元模式将享元对象的状态外部化，而读取外部状态使得运行时间变长。
 */
public class TestWeather {
	public static void main(String[] args) {
		WeatherFactory factory = new WeatherFactory();
		IWeather weather1, weather2, weather3, weather4, weather5, weather6, weather7, weather8;
		weather1 = factory.getFlyWeight("多云", 15);
		weather2 = factory.getFlyWeight("晴", 23);
		weather3 = factory.getFlyWeight("多云", 16);
		weather4 = factory.getFlyWeight("阴", 10);
		weather5 = factory.getFlyWeight("多云", 15);
		weather6 = factory.getFlyWeight("多云", 15);
		weather7 = factory.getFlyWeight("多云", 15);
		weather8 = factory.getFlyWeight("多云", 15);
		weather1.printWeather();
		weather2.printWeather();
		weather3.printWeather();
		weather4.printWeather();
		weather5.printWeather();
		weather6.printWeather();
		weather7.printWeather();
		weather8.printWeather();
		System.out.println("实际对象个数" + factory.getFlyweightSize());
	}
}
