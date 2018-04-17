package com.anxxp.bookte;

import java.util.Iterator;

public class BookAdapter extends Book implements Iterable<String> {
	@Override
	public Iterator<String> iterator() {
		return new IteratorAdapter(getEnum());
	}
}
