package com.anxxp.adapter;

/**
 * 可以看到，类适配器与对象适配器的区别就是类适配器需要继承被适配者，而Java的单继承的，所以通常情况下，使用对象适配器更好。
 * <p>
 * 如果目标接口中的方法数与被适配器者中的数目相同，就是完全适配，若目标接口中的方法更多，则是剩余适配，反之，为不完全适配。
 */

/**
 * 組合模式不妨用於其中，定義一個內置的Adaptee類對象即可
 */
public class ClassAdapter extends Adaptee implements Target {
	/**
	 * 需要做哪些處理？
	 * @param src
	 */
	@Override
	public void playFlac(Object src) {
		/**
		 * 可能需要歲src做處理
		 */
		playMp3(src);
	}
}
