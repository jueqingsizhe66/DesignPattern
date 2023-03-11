package com.qny.ShareWe;

import java.util.Scanner;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: TestPhoneCamera.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.ShareWe
 * @Time: 2023/3/11 23:32
 */
public class TestPhoneCamera {
    public static void main(String[] args) {
//        AbsPhoneCameraApp cameraApp = new BasicPhoneCameraIMPL();
        AbsPhoneCameraApp cameraApp = new ExtraPhoneCameralIMPL();
        String share = getSharing();
        switch (share){
            case("t"): cameraApp.setShareStrategic(new ShareByTXT()); break;
            case("e"): cameraApp.setShareStrategic(new ShareByEmail());break;
            case("s"): cameraApp.setShareStrategic(new ShareBySocial());break;
            default: cameraApp.setShareStrategic(new ShareByTXT());
        }

        cameraApp.take();
        cameraApp.edit();
        cameraApp.save();
        cameraApp.share();

    }
    public static String getSharing() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Share with txt (t), email (e), or social media (s)?");
        String appName = scanner.next();
        scanner.close();
        return appName;
    }
}
