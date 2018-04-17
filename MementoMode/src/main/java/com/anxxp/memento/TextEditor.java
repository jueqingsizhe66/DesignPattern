package com.anxxp.memento;

import java.util.LinkedList;

/**
 * 上例演示仅保存一个检查点。下面再给出一个实际的例子：
 * <p>
 * 我们有个程序，供用户编辑文本，用户做出修改后，可以保存文本，保存修改后，可以依次恢复到保存前的多个状态中的一个，
 * 如果恢复后用户没有修改，还可以取消恢复（重做），下面就演示整个程序。
 * <p>
 * 这个程序为了保证功能相对完整，写作演示可能有点长了：
 */
public class TextEditor {
	public static void main(String[] args) {
		//使用这个文本编辑器
		MyTextEditor editor = new MyTextEditor("这里是初始文本，可能为文件中读取的值。");
		System.out.println("开始修改文本：");
		editor.append("添加文字1");
		editor.delWords();        //删除最后一个
//		editor.delWords(2);		//删除最后2个	这两个方法是没有问题的，这里避免控制台输出太多，取消这两次修改
//		editor.delWords(1,5);	//删除前面5个
		System.out.println("开始恢复：");
		for (int i = 0; i < 10; i++) editor.recoverMemento();//恢复大于实际修改的次数不会出错，只会将文本设为o初始化状态
		System.out.println("开始重做：");
		for (int i = 0; i < 10; i++) editor.redo();        //重做大于实际恢复的次数不会出错，只会将文本设为最后状态
		System.out.println("再次恢复：");
		for (int i = 0; i < 10; i++) editor.recoverMemento();//恢复大于实际修改的次数不会出错，只会将文本设为o初始化状态
		System.out.println("再次重做：");
		for (int i = 0; i < 10; i++) editor.redo();        //重做大于实际恢复的次数不会出错，只会将文本设为最后状态
		System.out.println("再次恢复：");
		for (int i = 0; i < 10; i++) editor.recoverMemento();//恢复大于实际修改的次数不会出错，只会将文本设为o初始化状态
		editor.append("添加文字2");
		System.out.println("再次重做：");
		for (int i = 0; i < 10; i++) editor.redo();        //重做大于实际恢复的次数不会出错，只会将文本设为最后状态
	}
}

interface IMementoSon {
}

//发起人兼负责人
class MyTextEditor {
	public StringBuffer text;
	private LinkedList<IMementoSon> mementos;    //保存快照
	private LinkedList<IMementoSon> undos;        //保存撤销的操作
	
	public MyTextEditor() {
		this("");
	}
	
	public MyTextEditor(String defaultStr) {
		text = new StringBuffer(defaultStr);
		mementos = new LinkedList<IMementoSon>();
		undos = new LinkedList<IMementoSon>();
		print();
	}
	
	public void clearHistory() {
		mementos.clear();
		undos.clear();
	}
	
	public void append(String appendStr) {
		if (appendStr == null || appendStr.length() == 0) return;
		createMemento();
		text.append(appendStr);
		print();
		undos.clear();
	}
	
	//删除最后一个
	public void delWords() {
		delWords(1);
	}
	
	//删除最后n个
	public void delWords(int n) {
		if (n < 1 || n > text.length()) return;
		delWords(text.length() - n + 1, text.length());
	}
	
	//删除中间start到end的字符,第一个文字为第一个(而不是0)
	public void delWords(int start, int end) {
		if (start < 1 || end > text.length() + 1) return;
		createMemento();
		text = text.delete(start - 1, end);
		print();
	}
	
	public void reset(String text) {
		this.text = new StringBuffer(text);
	}
	
	//新的快照
	public void createMemento() {
		mementos.push(new MementoSon(this));
	}
	
	//恢复状态
	public boolean recoverMemento() {
		MementoSon memento = (MementoSon) mementos.poll();
		if (memento == null) return false;
		undos.push(new MementoSon(this));
		reset(memento.state);
		print();
		return true;
	}
	
	//redo,redo的操作也可以恢复！
	public boolean redo() {
		MementoSon memento = (MementoSon) undos.poll();
		if (memento == null) return false;
		createMemento();
		reset(memento.state);
		print();
		return true;
	}
	
	//内部类实现备忘录
	private class MementoSon implements IMementoSon {
		private String state;
		
		private MementoSon(MyTextEditor editor) {
			this.state = editor.text.toString();
		}
	}
	
	void print() {
		System.out.println("当前文本：" + text);
	}
}