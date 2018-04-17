package com.anxxp.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 目录节点
 */
public class Folder implements Component {
	private String name;
	private List<Component> files;
	private List<Component> folders;
	
	public Folder(String name) {
		this.name = name;
		files = new ArrayList<Component>();
		folders = new ArrayList<Component>();
	}
	
	@Override
	public void addFile(Component file) {
		files.add(file);
	}
	
	@Override
	public void removeFile(Component file) {
		files.remove(file);
	}
	
	@Override
	public void removeFolder(Component folder) {
		folders.remove(folder);
	}
	
	@Override
	public void display() {
		System.out.println(name);
	}
	
	@Override
	public Component addFolder(Component folder) {
		folders.add(folder);
		return this;
	}
	
	@Override
	public List<Component> getFiles() {
		List<Component> all = new ArrayList<Component>(folders);
		all.addAll(files);
		return all;
	}
	
	@Override
	public List<Component> getFolders() {
		//return null;
		// 返回空 则失败
		return folders;
	}
	
	/**
	 * 为什么需要重置iterator类
	 * 值得好好思考
	 * Iterator的作用是所有东西可以当作叶子节点来遍历
	 *
	 * @return
	 */
	@Override
	public Iterator<Component> iterator() {
		List<Component> all = new ArrayList<Component>();
		/**
		 * 对象引用类型
		 */
		add(all, this);
		return all.iterator();
	}
	
	/**
	 * 递归函数便利所有节点
	 *
	 * @param all
	 * @param component
	 */
	private void add(List<Component> all, Component component) {
		if (component == null) {
			return;
		}
		all.add(component);
		Iterator<Component> iterator = component.getFolders().iterator();
		while (iterator.hasNext()) {
			add(all, iterator.next());
		}
		all.addAll(component.getFiles());
	}
	/**
	 *  输出与我们预期想得到的迭代器是一样的（从某一个目录开始，先输出目录名，然后如果有目录，
	 *  就递归进入下一级目录，如果没有目录，就输出文件列表）。
	 文件和目录（Composite和Leaf）实现了相同的接口，所以操作起来很方便，包括迭代。
	 */
}
