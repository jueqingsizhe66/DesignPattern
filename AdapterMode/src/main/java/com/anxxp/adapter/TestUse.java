package com.anxxp.adapter;

public class TestUse {
	public static void main(String[] args) {
		Adaptee adaptee = new Adaptee();
		adaptee.playMp3("mp3");
		
		Target target = new ClassAdapter();
		target.playFlac("flac");
		
		target = new ObjectApter();
		target.playFlac("flac");
	}
}
