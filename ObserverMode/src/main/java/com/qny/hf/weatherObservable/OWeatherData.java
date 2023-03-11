package com.qny.hf.weatherObservable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: OWeatherData.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.hf.weatherObservable
 * @Time: 2023/3/11 22:46
 */
public class OWeatherData implements OSubject{
    private List<OWeather> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public OWeatherData() {
        this.observers = new ArrayList<OWeather>();
    }

    @Override
    public void registerObserver(OWeather ow) {
        observers.add(ow);
    }

    @Override
    public void removeObserver(OWeather ow) {
        observers.remove(ow);
    }

    @Override
    public void notifyObserver() {

        for (OWeather observer : observers) {
            observer.update(temperature,humidity,pressure);
        }
    }

    public void measurementsChanged(){
        notifyObserver();
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure  = pressure;
        notifyObserver();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
