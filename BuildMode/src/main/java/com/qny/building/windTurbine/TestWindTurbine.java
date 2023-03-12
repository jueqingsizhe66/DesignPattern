package com.qny.building.windTurbine;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: TestWindTurbine.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.building.windTurbine
 * @Time: 2023/3/12 19:10
 */
public class TestWindTurbine {
    public static void main(String[] args) {
        HaiZhuang haizhuang = new HaiZhuang();
        WindTurbine windTurbine = haizhuang.getProduct();
        System.out.println(windTurbine);

        WindTurbine windTurbine180 = haizhuang.buildBlade("双瑞叶片").buildMainBearing("新强联主轴承").buildGearBox("望江齿轮箱").getProduct();
        System.out.println(windTurbine180);

        DongQi dongqi = new DongQi();
        WindTurbine windTurbineDongqi= dongqi.buildBlade("东气叶片").getProduct();
        System.out.println(windTurbineDongqi);

    }
}
