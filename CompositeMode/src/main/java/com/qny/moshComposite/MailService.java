package com.qny.moshComposite;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: MailService.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.qny.moshComposite
 * @Time: 2023/3/11 0:02
 */
public class MailService {
    public void sendMail(String address, String content){
        connent(30);
        authenticate();
        disconnet();

        /**
         * private这些方法  那么二次开发用户就无法访问了
         */
    }

    /*
    注意public 改为private
     */
    private void connent(int timeout){
        System.out.println("connect");
    }


    private void disconnet(){
        System.out.println("disconnect");
    }

    private void authenticate(){
        System.out.println("Authenticate");
    }


}
