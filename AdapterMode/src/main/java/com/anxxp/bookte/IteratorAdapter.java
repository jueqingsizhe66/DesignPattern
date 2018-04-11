package com.anxxp.bookte;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 適配器，目標就是Iterator，被適配者是Enumeration
 */
public class IteratorAdapter implements Iterator<String> {
	Enumeration<String> myEnum;
	
	@Override
	public boolean hasNext() {
		return myEnum.hasMoreElements();
	}
	
	@Override
	public String next() {
		return myEnum.nextElement();
	}
	
	public IteratorAdapter(Enumeration<String> myEnum) {
		this.myEnum = myEnum;
	}
}
