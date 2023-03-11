package com.qny.hf.weatherObservable;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: ForecastDisplay.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.hf.weatherObservable
 * @Time: 2023/3/11 22:54
 */
public class ForecastDisplay implements OWeather, DisplayElement{
    private float currentPressure  =   29.92f;
    private float lastPressure ;
    private OWeatherData weatherData;

    public ForecastDisplay(OWeatherData weatherData) {
        this.weatherData = weatherData;
        /**
         * 构造函数直接引入实例化对象
         */
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {

        System.out.println("Display: ");
        if (currentPressure>lastPressure) {
            System.out.println("Improving weather on the way ----");
        }else if (currentPressure != lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("watch out for cooler ,rain weather");
        }
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        lastPressure=currentPressure;
        currentPressure = pressure;
        display();

    }
}
