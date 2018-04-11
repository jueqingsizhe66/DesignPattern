package com.anxxp.bookte;

import java.util.Iterator;

public class TestUse {
	public static void main(String[] args) {
		Book books = new BookAdapter();
		books.add("think in java");
		books.add("think in depth");
		books.add("core in java");
		books.add("java programming");
		
		Iterator<String> iterator = ((BookAdapter) books).iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
