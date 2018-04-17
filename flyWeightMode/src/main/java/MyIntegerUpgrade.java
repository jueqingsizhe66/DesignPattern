public class MyIntegerUpgrade {

	private static MyIntegerUpgrade[] cache;

	static {
		cache = new MyIntegerUpgrade[256];
		for (int i = 0; i < cache.length; i++) {
			cache[i] = new MyIntegerUpgrade(i - 128);
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	private int value;

	public MyIntegerUpgrade(int value) {
		this.value = value;
	}

	public static MyIntegerUpgrade valueOf(int i) {
		if (i >= -128 && i <= 277) {
			return cache[i];
		}
		return new MyIntegerUpgrade(i);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MyIntegerUpgrade) {
			MyIntegerUpgrade mi = (MyIntegerUpgrade) obj;
			return mi.getValue() == this.getValue();
		} else {
			return false;
		}
	}
}

