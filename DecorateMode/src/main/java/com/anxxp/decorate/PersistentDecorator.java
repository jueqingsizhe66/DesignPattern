package com.anxxp.decorate;


/**
 * 首先需要抽象一个装饰器，我们不能直接使用它(即使使用匿名内部类使用了它，也跟最初的实现效果一样，没有意义)，因为他是一个抽象类（装饰）
 * 增加abstract和不增加都可以运行
 * 增加的化，代表这个PersistentMsg不能创建  只能被继承之后才能运行
 */
public abstract class PersistentDecorator implements IPersistenUtil {
	IPersistenUtil iPersistenUtil;

	public PersistentDecorator(IPersistenUtil iPersistenUtil) {
		this.iPersistenUtil = iPersistenUtil;
	}

	@Override
	public void persistentMsg(String msg) {
		iPersistenUtil.persistentMsg(msg); // 并未实现， 依然抽象
		
	}
}
