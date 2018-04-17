package com.anxxp.memento;

/**
 * 上面两个例子[Simple and Black]，演示的都是保存一个状态（不是指一个成员，而是只存了最近一次状态），即一个检查点，但是实际应用中，
 * 状态往往不止存储一次，我们将上面储存状态的变量改为一个栈（或队列，主要看需求）即可。比如：BlackCaretaker中的
 * private MementoIF memento；改为LinkedList<MementoIF> mementos 实现，保存的时候压栈（入队），恢复的时候出栈（出队）。具体实现都已经描述很清楚了，代码就不贴了（文章本来就太长了）。
 * <p>
 * 针对上例，如果发起人和负责人我们并不介意他们必须是独立的，就可以把他们融合到一起，实现就会更佳简单，代码也简洁：
 * 于是有了MemtoSelf
 */
public class BlackMemento {
	//备忘录模式
	public static void main(String[] args) {
		BlankOriginator originator = new BlankOriginator();    //发起人
		BlackCaretaker caretaker = new BlackCaretaker();    //负责人
		originator.setState("stateOne");    //设置状态
		caretaker.saveMemento(originator.createMemento());    //保存信息
		originator.setState("stateTwo");    //修改状态
		originator.recoverMemento(caretaker.recoverMemento());//恢复状态
	}
}

interface MementoIF {
}

//发起人
class BlankOriginator {
	private String state;
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public MementoIF createMemento() {
		return new Memento(state);
	}
	
	public void recoverMemento(MementoIF memento) {
		this.setState(((Memento) memento).getState());
	}
	
	//以内部类实现备忘录角色
	private class Memento implements MementoIF {
		private String state;
		
		private Memento(String state) {
			this.state = state;
		}
		
		private String getState() {
			return state;
		}
	}
}

//负责人
class BlackCaretaker {
	private MementoIF memento;
	
	public MementoIF recoverMemento() {
		return memento;
	}
	
	public void saveMemento(MementoIF memento) {
		this.memento = memento;
	}
}