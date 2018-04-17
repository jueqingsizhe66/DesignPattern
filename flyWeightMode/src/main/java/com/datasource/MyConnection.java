package com.datasource;

public class MyConnection {
	private boolean closed = false;

	public MyConnection() {
		try {
			Thread.sleep(3000);//模拟很耗资源的对象创建过程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void send(String data) {
		if (closed) {
			throw new RuntimeException("already closed");
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("发送" + data);
	}

	public void close() {
		closed = true;
	}

	public boolean isClosed() {
		return this.closed;
	}

}
