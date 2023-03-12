package com.qny.building.windTurbine;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: DongQi.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.building.windTurbine
 * @Time: 2023/3/12 19:08
 */
public class DongQi extends WindTurbineFactory{
    private WindTurbine windTurbine;

    public DongQi() {
        this.windTurbine = new WindTurbine();
    }

    @Override
    WindTurbineFactory buildBlade(String msg) {
        windTurbine.setBlade(msg);
        return this;
    }

    @Override
    WindTurbineFactory buildMainBearing(String msg) {
        windTurbine.setMainBearing(msg);
        return this;
    }

    @Override
    WindTurbineFactory buildGearBox(String msg) {
        windTurbine.setGearBox(msg);
        return this;
    }

    @Override
    WindTurbineFactory buildGenerator(String msg) {
        windTurbine.setGenerator(msg);
        return this;
    }

    @Override
    WindTurbineFactory buildPLC(String msg) {
        windTurbine.setPlc(msg);
        return this;
    }

    @Override
    WindTurbine getProduct() {
        return windTurbine;
    }
}
