public class TestRealStragety {
	private String salt = "edu.f708";
	private IDigestStragety digestStragety;

	public TestRealStragety(IDigestStragety digestStragety) {
		super();
		this.digestStragety = digestStragety;
	}

	public String calcStringHash(String value) {
		return digestStragety.digest(value + salt);
	}

	public boolean checkValueHash(String hashValue, String value) {
		String hashValue2 = this.digestStragety.digest(value);
		return hashValue2.equalsIgnoreCase(hashValue);

	}

	/*
	这样只要创建Test2的时候只要传递不同的IDigestStragety实现类即可，如果增加新的散列算法，用户只要自定义类实现IDigestStragety接口，然后提供进去就行了。消灭了if，符合“开闭原则”
	 */
	public static void main(String[] args) {
		TestRealStragety t2 = new TestRealStragety(new MD5Stragety());
		String hash = t2.calcStringHash("123456");
		System.out.println(hash);
		System.out.println(t2.checkValueHash(hash, "123456"));
	}
}
