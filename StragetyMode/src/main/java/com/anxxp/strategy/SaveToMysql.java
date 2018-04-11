package com.anxxp.strategy;

public class SaveToMysql implements ISaveData {
	@Override
	public void save(Object data) {
		System.out.println("数据： "+ data+ " 保存到mysql");
	}
}
