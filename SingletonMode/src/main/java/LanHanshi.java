public class LanHanshi {
	// 懒汉式 没有实例化！
	private static LanHanshi instance = null;

	/**
	 * 区分于饿汉式
	 */
	public LanHanshi() {

	}

	// 可以在LanHanshi前面增加synchronized
	// 也可以在方法类中添加synchronized(LanHanshi.class )
	// 但是最好不要使用懒汉式
	public static LanHanshi getInStanc() {
		// 多进程可能创建多个instance  不要使用
		if (instance == null) //如果为空则创建
		{
			//性能变低了
			synchronized (LanHanshi.class) // 进入同步代码快
			{
					instance = new LanHanshi();
			}
		}
		return instance;
	}
}

