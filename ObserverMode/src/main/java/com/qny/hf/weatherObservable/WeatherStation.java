package com.qny.hf.weatherObservable;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: WeatherStation.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.hf.weatherObservable
 * @Time: 2023/3/11 23:06
 */
public class WeatherStation {
    public static void main(String[] args) {
        OWeatherData weatherData = new OWeatherData();
        CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

        weatherData.removeObserver(forecastDisplay);
        weatherData.setMeasurements(62, 90, 28.1f);
    }
}
