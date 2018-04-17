package com.anxxp.mediator;

public class PersistentDB implements IPersistent {
	private Object data;
	
	@Override
	public void getData(Object data) {
		this.data = data;
		saveData();
	}
	
	@Override
	public void getData(Object data, Midiator midiator) {
		getData(data);
		midiator.notifyOther(this, data);
	}
	
	@Override
	public void saveData() {
		System.out.println(data + "PersistentDB已保存到数据库");
	}
}
