import java.nio.charset.Charset;

public class TestCharset {
	public static void main(String[] args) {
		//Charset c1= Charset.forName()
		Charset c1 = Charset.forName("UTF-8");
		Charset c2 = Charset.forName("GBK");
		Charset c3 = Charset.forName("Big5");
		Charset c4 = Charset.forName("UTF-32");
		System.out.println(c1.getClass());
		System.out.println(c2.getClass());
		System.out.println(c3.getClass());
		System.out.println(c4.getClass());

	}
}
