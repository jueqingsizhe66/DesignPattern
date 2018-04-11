package com.anxxp.strategy;

/**
 * 策略2
 */
public class SaveToFile implements ISaveData {
	@Override
	public void save(Object data) {
		System.out.println("数据： "+ data+" 保存到文件");
	}
}
