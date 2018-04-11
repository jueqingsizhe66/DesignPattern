package com.anxxp.memento;

/**
 * 备忘录角色对任何对象都提供一个接口，备忘录角色的内部所存储的状态就对所有对象公开，因此是破坏封装性的。

    按照定义中的要求，备忘录角色要保持完整的封装。最好的情况便是：备忘录角色只应该暴露操作内部存储属性的的接口给“备忘发起角色”。

    如果上例中，我们把备忘录以发起人的私有内部类的方式实现的话，那它就只能被发起人访问了，这正好就符合备忘录模式的要求，但是我们的负责人是需要存放备忘录的引用的，于是，我们提供一个公共的接口，他是空的，我们用备忘录实现它，主要就是利用其中的类型信息，具体实现如下：
 于是有了BlackMemento
 */
public class SimpleMemento {
	public static void main(String[] args) throws Exception {
		Originator originator = new Originator();	//发起人，要被保存的对象,也是他创建要保存的信息的
		Caretaker caretaker = new Caretaker();		//辅助保存的对象
		originator.setState("stateOne");	//设置状态
		caretaker.saveMemento(originator.createMemento());		//保存状态
		originator.setState("stateTwo");	//修改状态
		originator.recoverMemento(caretaker.recoverMemento());	//恢复状态
	}
}
//发起人
class Originator {
	private String state;
	public Memento createMemento(){
		return new Memento(state);
	}
	public void recoverMemento(Memento memento){
		this.state = memento.getState();
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
//备忘录
class Memento {
	private String state;
	public Memento(String state){
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
//负责人
class Caretaker {
	private Memento memento;
	public Memento recoverMemento() throws Exception{
		if(memento==null)
			throw new Exception("没有保存的状态");
		return this.memento;//恢复状态
	}
	public void saveMemento(Memento memento){
		this.memento = memento;//保存状态
	}
}