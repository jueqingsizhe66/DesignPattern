package com.qny.hf.weatherObservable;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: HeatIndexDisplay.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.hf.weatherObservable
 * @Time: 2023/3/11 22:59
 */
public class HeatIndexDisplay implements OWeather, DisplayElement {
    float heatIndex = 0.0f;
    private OWeatherData weatherData;

    public HeatIndexDisplay(OWeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Heat Index is " + heatIndex);

    }
    private float computeHeatIndex(float t, float rh) {
        float index = (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh)
                + (0.00941695 * (t * t)) + (0.00728898 * (rh * rh))
                + (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
                (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
                (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
                (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
                0.000000000843296 * (t * t * rh * rh * rh)) -
                (0.0000000000481975 * (t * t * t * rh * rh * rh)));
        return index;
    }
    @Override
    public void update(float temp, float humidity, float pressure) {

        heatIndex = computeHeatIndex(temp,humidity);
        display();
    }
}
