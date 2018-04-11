package com.anxxp.bridge;

public class LocalSave extends AbstractSave {
	public LocalSave(ISaveData saveData) {
		
		super(saveData);
	}
	
	@Override
	public void save(Object data) {
		System.out.println("本地存储 ：");
		saveData.save(data);
		
	}
}
