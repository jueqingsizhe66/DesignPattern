package com.anxxp.iterator;

/**
 * 只需要便利一堆数据 那么只需要2个方法即可
 *
 * @param <T>
 */
public interface MyIterator<T> {
	boolean hasNext();    //是否还有下一个元素
	
	T next();            //得到下一个元素
	
	T remove();
}
