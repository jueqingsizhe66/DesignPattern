package com.anxxp.StatusMode;

public enum SaveBigData implements ISaveData{
	instance;
	@Override
	public void save(Object data) {
		System.out.println("保存到硬盘文件： "+data);
	}
}
