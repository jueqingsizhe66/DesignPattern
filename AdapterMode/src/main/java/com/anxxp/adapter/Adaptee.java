package com.anxxp.adapter;

/**
 * 原來的適配器 只播放MP3
 */
public class Adaptee {
	void playMp3(Object src) {
		System.out.println("播放Mp3: " +src);
	}
}
