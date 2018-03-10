package com.com.dom;

import java.io.File;

/*
文件和文件夹同等看待
 */
public class TestFile {
    public static void main(String[] args) {
        File file = new File("G:\\IntellijHome\\rupengImprove\\designer");
        print(file, 0);
    }
    static void print(File file, int depth) {
        if (file.isFile()) {
            System.out.println(repeatSpace(depth) + "文件：" + file.getName());
        } else if (file.isDirectory()) {
            System.out.println(repeatSpace(depth) + "文件夹：" + file.getName());
            File[] childFiles = file.listFiles();
            if (childFiles != null) {//如果没有权限，则会返回null
                for (File childFile : childFiles) {
                    print(childFile, depth + 1);
                }
            }
        }
    }
    static String repeatSpace(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

}
