package com.anxxp.adapter;

/**
 * 對象適配器
 */
public class ObjectApter implements Target {
	
	/**
	 * 增加一個私有變量
	 */
	private Adaptee adaptee;

	public ObjectApter() {
		super();
		adaptee = new Adaptee();
	}
	
	/**
	 * 新的方法需對來源做一些處理, 怎麼處理？
	 *
	 * @param src
	 */
	@Override
	public void playFlac(Object src) {
		//可能需要對src做處理
		adaptee.playMp3(src);
		
	}
}
