package com.anxxp.decorate;

/**
 * 装饰器1
 */
public class PersistentDbDecorator extends PersistentDecorator {
	public PersistentDbDecorator(IPersistenUtil iPersistenUtil) {
		super(iPersistenUtil);
	}
	
	@Override
	public void persistentMsg(String msg) {
		iPersistenUtil.persistentMsg(msg);
		persistentToDb(msg);
	}
	
	private void persistentToDb(String msg) {
		System.out.println(msg + " 存入数据库");
	}
}
