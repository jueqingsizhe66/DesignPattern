public class MyInteger {
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	private int value;

	public MyInteger(int value) {
		this.value = value;
	}

	public static MyInteger valueOf(int i) {
		return new MyInteger(i);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MyInteger) {
			MyInteger mi = (MyInteger) obj;
			return mi.getValue() == this.getValue();
		} else {
			return false;
		}
	}
}
