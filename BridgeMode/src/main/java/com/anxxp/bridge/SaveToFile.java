package com.anxxp.bridge;

public class SaveToFile implements ISaveData {
	
	@Override
	public void save(Object data) {
		System.out.println(data+"存储到文件");
	}
}
