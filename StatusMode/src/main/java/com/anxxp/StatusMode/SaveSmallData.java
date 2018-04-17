package com.anxxp.StatusMode;

public enum SaveSmallData implements ISaveData {
	instance;
	
	@Override
	public void save(Object data) {
		System.out.println("保存到Redis: " + data);
	}
}
