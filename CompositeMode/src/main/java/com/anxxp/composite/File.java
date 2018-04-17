package com.anxxp.composite;

import java.util.Iterator;
import java.util.List;

public class File implements Component {
	private String name;
	
	public File(String name) {
		this.name = name;
	}
	
	@Override
	public void addFile(Component file) {
		System.out.println("具体叶子结点文件无法添加文件");
	}
	
	@Override
	public Component addFolder(Component folder) {
		return null;
	}

	@Override
	public void removeFile(Component file) {
		System.out.println("具体叶子结点文件无法删除文件");
	}
	
	@Override
	public void removeFolder(Component folder) {

	}
	
	@Override
	public void display() {
		System.out.println(name);
	}

	
	@Override
	public List<Component> getFiles() {
		return null;
	}
	
	@Override
	public List<Component> getFolders() {
		return null;
	}
	
	@Override
	public Iterator<Component> iterator() {
		return null;
	}
}
