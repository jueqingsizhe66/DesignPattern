public class TestMyIntegerUpgrade {
	public static void main(String[] args) {
		MyIntegerUpgrade m1 = new MyIntegerUpgrade(1);
		MyIntegerUpgrade m2 = new MyIntegerUpgrade(1);
		System.out.println(m1 == m2);
		System.out.println(m1.equals(m2));

		MyIntegerUpgrade m3 = MyIntegerUpgrade.valueOf(2);
		MyIntegerUpgrade m4 = MyIntegerUpgrade.valueOf(2);
		System.out.println(m3 == m4);
		System.out.println(m3.equals(m4));

	}
}
