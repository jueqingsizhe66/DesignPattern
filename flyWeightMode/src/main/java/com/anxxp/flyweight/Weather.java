package com.anxxp.flyweight;

public class Weather implements IWeather {
	private String weather;
	private Integer temperature;
	
	public Weather(String weather, Integer temperature) {
		this.weather = weather;
		this.temperature = temperature;
	}
	
	@Override
	public void printWeather() {
		System.out.println("天气：" + weather);
		System.out.println("   温度:" + temperature);
	}
	
	@Override
	public int hashCode() {//Integer和String的hashCode(）方法都是合理的，取均值即可
		return (weather.hashCode() + temperature.hashCode())/2;
	}
	
	@Override
	public boolean equals(Object obj) {
		Weather weatherObj=(Weather)obj;
		return weatherObj.weather.equals(this.weather) && weatherObj.temperature==temperature;
	}
}
