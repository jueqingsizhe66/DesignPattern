package com.qny.hf.simple;

public interface ESubject {
    public void registerObserver(EObserver o);
    public void removeObserver(EObserver o);
    public void notifyObserver();
}
