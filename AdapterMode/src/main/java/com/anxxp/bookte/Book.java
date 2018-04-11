package com.anxxp.bookte;

import java.util.Enumeration;
import java.util.Vector;

public class Book {
	private Vector<String> books;
	
	public Book() {
		books = new Vector<String>();
	}
	
	public void add(String book) {
		books.add(book);
	}
	
	public Enumeration<String> getEnum() {
		return books.elements();
	}
}
