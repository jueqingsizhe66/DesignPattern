package com.qny.building.windTurbine;


/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: HaiZhuang.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.building.windTurbine
 * @Time: 2023/3/12 18:56
 */
public class HaiZhuang extends WindTurbineFactory {
    private WindTurbine windTurbine;

    public HaiZhuang() {
        this.windTurbine = new WindTurbine();
    }

    @Override
    WindTurbineFactory buildBlade(String msg) {
        this.windTurbine.setBlade(msg);
        return this;
    }

    @Override
    WindTurbineFactory buildMainBearing(String msg) {
        this.windTurbine.setMainBearing(msg);
        return this;
    }

    @Override
    WindTurbineFactory buildGearBox(String msg) {
        this.windTurbine.setGearBox(msg);
        return this;
    }

    @Override
    WindTurbineFactory buildGenerator(String msg) {
        this.windTurbine.setGenerator(msg);
        return this;
    }

    @Override
    WindTurbineFactory buildPLC(String msg) {
        this.windTurbine.setPlc(msg);
        return this;
    }

    @Override
    WindTurbine getProduct() {
        return this.windTurbine;
    }
}
