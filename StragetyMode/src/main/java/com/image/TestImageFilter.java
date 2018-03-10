package com.image;

import java.io.File;

public class TestImageFilter {
    public static void main(String[] args) {
        File file = new File("D://手机电脑");
        File[] listFiles = file.listFiles(new ImageFilter());
        for (File f : listFiles) {
            System.out.println(f.getName());
        }
        System.out.println("Total + "+listFiles.length);

    }
}
