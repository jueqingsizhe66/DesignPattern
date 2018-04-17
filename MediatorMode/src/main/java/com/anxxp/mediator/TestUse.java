package com.anxxp.mediator;

/**
 * 比如有两个类，他们都是做持久化的，一个负责将数据写入文件，一个负责将数据写入数据库。
 * 他们谁先接收到数据是不确定的，但是要确保其中一个接收到数据后，另外一个也必须完成这些数据的持久化。
 * 如果我们直接将两个类关联在一起，互相调用是可以实现的，但不利于后期扩展或维护（比如再添加一个持久化组建，
 * 则原有的组建可能都需要修改），此时，若添加一个中介者，来协调他们，事儿就好办多了：
 */
public class TestUse {
	public static void main(String[] args) {
		Object data = "数据";
		PersistentDB persistentDB = new PersistentDB();
		PersistentFile persistentFile = new PersistentFile();
		Midiator midiator = new Midiator();
		//在中介处备注，注册，然后只要遍历即可  不让线下交易
		//中介者消除了同事与同事间直接的关联。
		midiator.setPersistentDB(persistentDB).setPersistentFile(persistentFile);
		persistentDB.getData(data, midiator); //会通知其他同事也做好数据备份
		persistentFile.getData(data, midiator);
	}
}
