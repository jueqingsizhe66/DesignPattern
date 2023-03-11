package com.qny.hf.weatherObservable;

public interface OSubject {
    public void registerObserver(OWeather ow);
    public void removeObserver(OWeather ow);
    public void notifyObserver();

}
