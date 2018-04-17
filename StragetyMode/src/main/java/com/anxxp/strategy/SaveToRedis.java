package com.anxxp.strategy;

/**
 * 策略1
 */
public class SaveToRedis implements ISaveData {
	@Override
	public void save(Object data) {
		System.out.println("数据： " + data + " 保存到Redis");
	}
}
