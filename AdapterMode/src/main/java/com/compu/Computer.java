package com.compu;

//未实现自动关闭 closable  但try-with resource 不支持不带closable的资源
public class Computer {

	public Computer() {

	}

	public void play() {
		System.out.println("开了 正播放");
	}

	public void close() {
		System.out.println("关了");
	}
}

