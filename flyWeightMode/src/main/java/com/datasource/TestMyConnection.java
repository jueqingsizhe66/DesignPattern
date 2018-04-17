package com.datasource;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class TestMyConnection {
	public static void main(String[] args) {
		PooledMyConnectionFactory fac = new PooledMyConnectionFactory();// 工厂对象
		GenericObjectPoolConfig conf = new GenericObjectPoolConfig();   // 配置对象
		conf.setMaxTotal(10); // 最大活动链接  创建10大链接
		conf.setMaxIdle(3); // 最大空闲连接数  有些可能会被销毁 //默认是8
		GenericObjectPool<MyConnection> pool = new GenericObjectPool<>(fac, conf);  // 池对象(策略模式的感觉）
		// MyConnection可以替换为 String 字符串池, Socket 套接字池   在享元种模式中使用策略

		// 创建100个对象
		for (int i = 0; i < 100; i++) {
			int data = i;
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					MyConnection conn = null;
					try {
						conn = pool.borrowObject(); // 借一个对象
						conn.send("hello ThreadId= " + Thread.currentThread().getId() + "\t Data=" + data);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						pool.returnObject(conn); // 归还对象
					}
				}
			});
			t.start();

		}
	}
}
