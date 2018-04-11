package com.anxxp.bridge;

/**
 *  我们再次那数据存储举一个实际的例子。数据存储可以实现为存到文件或是存到数据库，而我们存储时可以选择是本地还是网络上的位置，下面一一道来：

    首先是定义数据存储的实现：
 
 saveToRedis
 saveToMemcached
 saveToMongoDB等
 
 很方便拓展
 */
public interface ISaveData {
	void save(Object data);
}
