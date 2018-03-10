package com.com.dom;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
/*
文件和文件夹同等替代
 */
public class TestTxtFind {
    public static void main(String[] args) {
        List<File> results = new LinkedList<>();
        findTxt(new File("G:\\IntellijHome\\rupengImprove\\designer"), results);
        for(File file : results)
        {
            System.out.println(file);
        }

    }
    static void findTxt(File file,List<File> results) {
        if (file.isFile()&&file.getName().endsWith(".txt")) {
            results.add(file);

        } else if (file.isDirectory())
        {
            File[] childFiles = file.listFiles();
            if (childFiles != null) {//如果没有权限，则会返回null
                for (File childFile : childFiles) {
                    findTxt(childFile, results);
                }
            }

        }
    }


}
