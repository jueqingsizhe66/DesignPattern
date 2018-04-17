package WithoutDecorate;

import java.util.ArrayList;
import java.util.List;

public class TestDe {

	static List<String> getData() {
		List<String> list = new ArrayList<>();
		list.add("abc");
		list.add("123");
		list.add("com.edu");
		list.add("F708");
		list.add("qq");
		return list;
	}

	// You don't want user to add or remove, decorate it
	public static void main(String[] args) {
		List<String> list = getData();
		for (String s : list) {
			System.out.println(s);
		}
	}
}
