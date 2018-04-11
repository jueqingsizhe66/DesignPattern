package com.anxxp.decorate;

public class TestUse {
	
	public static void main(String[] args) {
		//被装饰者
		final String data = "数据";
		IPersistenUtil iPersistenUtil = new PersistentUtil();
		iPersistenUtil.persistentMsg(data);
		
		System.out.println("下面装饰数据库持久化");
		iPersistenUtil = new PersistentDbDecorator(iPersistenUtil);
		iPersistenUtil.persistentMsg(data);
		System.out.println("下面继续装饰网络存储器持久化");
		iPersistenUtil = new PersistentNetDecorator(iPersistenUtil);
		iPersistenUtil.persistentMsg(data);
		
	}
}
