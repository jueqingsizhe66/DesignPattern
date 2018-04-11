package com.anxxp.bridge;

public class NetSave extends AbstractSave {
	public NetSave(ISaveData saveData) {
		super(saveData);
	}
	
	@Override
	public void save(Object data) {
		System.out.println("网络存储：");
		saveData.save(data);
		
	}
}
