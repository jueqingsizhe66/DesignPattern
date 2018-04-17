package com.anxxp.decorate;

public class PersistentUtil implements IPersistenUtil {
	@Override
	public void persistentMsg(String msg) {
		System.out.println(msg + "存入文件");
		
	}
}
