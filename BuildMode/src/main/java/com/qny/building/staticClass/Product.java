package com.qny.building.staticClass;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Product.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.building.staticClass
 * @Time: 2023/3/12 18:24
 */
//具体的产品套餐
public class Product {
    private String BuildA="汉堡";
    private String BuildB="可乐";
    private String BuildC="薯条";
    private String BuildD="甜点";
    public String getBuildA() {
        return BuildA;
    }

    public void setBuildA(String buildA) {
        BuildA = buildA;
    }

    public String getBuildB() {
        return BuildB;
    }

    public void setBuildB(String buildB) {
        BuildB = buildB;
    }

    public String getBuildC() {
        return BuildC;
    }

    public void setBuildC(String buildC) {
        BuildC = buildC;
    }

    public String getBuildD() {
        return BuildD;
    }

    public void setBuildD(String buildD) {
        BuildD = buildD;
    }

    @Override
    public String toString() {
        return "Product{" +
                "BuildA='" + BuildA + '\'' +
                ", BuildB='" + BuildB + '\'' +
                ", BuildC='" + BuildC + '\'' +
                ", BuildD='" + BuildD + '\'' +
                '}';
    }
}
