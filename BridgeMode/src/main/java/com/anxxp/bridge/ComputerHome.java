package com.anxxp.bridge;

/**
 * simpleBridge
 */
public class ComputerHome {
	public static void main(String[] args) {
		new LenevoComputer(new Amd()).discribe();
		new HaseeComputer(new Intel()).discribe();
	}
}//实现者

interface Cpu {
	String discribe();
}

//具体实现者*2
class Amd implements Cpu {
	public String discribe() {
		return "just so so...";
	}
}

class Intel implements Cpu {
	public String discribe() {
		return "great !";
	}
}

//抽象
abstract class AbstractComputer {
	/**
	 * 经典桥接模式：   抽象类里面加上1个字段和1个该字段的构造函数
	 * 所有继承类都会继承该字段属性， 那么子类的构造函数 只要更改不同的字段接口实现类，那么对应的方法就可以重载，并且重载方法可以增加其他输出（有点类似日记系统，切面编程，这么一说也有点类似装配者模式)
	 */
	Cpu cpu;

	public AbstractComputer(Cpu cpu) {
		this.cpu = cpu;
	}

	public abstract void discribe();
}

//细化抽象*2
class LenevoComputer extends AbstractComputer {
	public LenevoComputer(Cpu cpu) {
		super(cpu);
	}

	@Override
	public void discribe() {
		System.out.println("联想笔记本cpu:" + super.cpu.discribe());
	}
}

class HaseeComputer extends AbstractComputer {
	public HaseeComputer(Cpu cpu) {
		super(cpu);
	}

	@Override
	public void discribe() {
		System.out.println("神舟笔记本cpu:" + super.cpu.discribe());
	}
}//输出：联想笔记本cpu:just so so... 神舟笔记本cpu:great !
