package com.anxxp.decorate;

/**
 * 可以用Ctrl+O快捷键
 */
public class PersistentNetDecorator extends PersistentDecorator {
	public PersistentNetDecorator(IPersistenUtil iPersistenUtil) {
		super(iPersistenUtil);
	}
	
	@Override
	public void persistentMsg(String msg) {
		iPersistenUtil.persistentMsg(msg);
		pesistentToNet(msg);
	}
	
	private void pesistentToNet(String msg) {
		System.out.println(msg + "存入网络的其他地方");
	}
}
