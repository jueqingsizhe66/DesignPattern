package com.qny.building.windTurbine;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: WindTurbine.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.building.windTurbine
 * @Time: 2023/3/12 19:01
 */
public class WindTurbine {
    private String blade="叶片";
    private String mainBearing="主轴承";
    private String gearBox = "齿轮箱";
    private String generator="发电机";
    private String plc = "PLC";

    public String getBlade() {
        return blade;
    }

    public void setBlade(String blade) {
        this.blade = blade;
    }

    public String getMainBearing() {
        return mainBearing;
    }

    public void setMainBearing(String mainBearing) {
        this.mainBearing = mainBearing;
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public String getPlc() {
        return plc;
    }

    public void setPlc(String plc) {
        this.plc = plc;
    }

    @Override
    public String toString() {
        return "WindTurbine{" +
                "blade='" + blade + '\'' +
                ", mainBearing='" + mainBearing + '\'' +
                ", gearBox='" + gearBox + '\'' +
                ", generator='" + generator + '\'' +
                ", plc='" + plc + '\'' +
                '}';
    }
}
