package com.qny.hf.weatherObservable;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: CurrentConditionDisplay.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.hf.weatherObservable
 * @Time: 2023/3/11 22:45
 */
public class CurrentConditionDisplay implements OWeather, DisplayElement{
    private float temp;
    private float humidity;
    private float pressure;
    private OWeatherData weatherData;
    public CurrentConditionDisplay(OWeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temp
                + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }
}
