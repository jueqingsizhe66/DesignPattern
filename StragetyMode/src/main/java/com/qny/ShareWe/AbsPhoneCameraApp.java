package com.qny.ShareWe;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: AbsPhoneCameraApp.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.ShareWe
 * @Time: 2023/3/11 23:28
 */
public abstract class AbsPhoneCameraApp {
    ShareStrategic shareStrategic;

    public void setShareStrategic(ShareStrategic shareStrategic) {
        this.shareStrategic = shareStrategic;
    }
    public  void share(){
        shareStrategic.share();
    }
    public void take(){
        System.out.println("Taking the photo");

    }

    public  void save(){
        System.out.println("Saving the photo ");
    }

    public abstract void edit();
}
