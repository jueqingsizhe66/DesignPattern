public class EHanshiStaticCode {
	/**
	 * 理解创建唯一的对象， 并且设置构造函数为空
	 *  饿汉式静态变量的方式(Static)
	 * <p>
	 * 单例模式的主要目的是确保某个类在系统中有且只有一个对象，比如这个对象维持整个系统的共享状态等。
	 */
	private static EHanshiStaticCode instance;

	// 饿汉式都会造成内存浪费
	// 只加载一次
	static
	{
		instance = new EHanshiStaticCode();
	}
	private EHanshiStaticCode() {

	}

	public static EHanshiStaticCode getInstance() {
		return instance;
	}

}
