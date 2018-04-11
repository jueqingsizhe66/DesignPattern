package com.anxxp.composite;

import java.util.Iterator;

public class TestUse {
	public static void main(String[] args) {
		Component root = new Folder("root"); //根目录
		Component folder1 = new Folder("Java");
		Component folder2 = new Folder("Python");
		Component folder3 = new Folder("Perl");
		Component folder4 = new Folder("RUby");
		
		Component file1 = new File("Readme.md");
		
		//错误
		//root.addFolder(folder1).addFolder(folder2).addFolder(folder3).addFolder(folder4).addFolder(file1);// 添加一级目录
		root.addFolder(folder1).addFolder(folder2).addFolder(folder3).addFolder(folder4).addFile(file1);// 添加一级目录
		
		//folder1.addFolder(new File("info.java"));
		folder1.addFile(new File("info.java"));
		Iterator<Component> iterator = root.iterator(); //迭代器模式是List数据结构内置的
		while (iterator.hasNext()) {
			Component component = iterator.next();
			if (component instanceof Folder) {
				System.out.println("Folder: ");
			}else{
				System.out.println("File: ");
			}
			component.display();
		}
		
	}
}
