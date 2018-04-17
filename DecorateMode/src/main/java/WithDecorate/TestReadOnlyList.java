package WithDecorate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestReadOnlyList {
	static List<String> getData() {
		List<String> list = new ArrayList<>();
		list.add("abc");
		list.add("123");
		list.add("f708");
		list.add("ncepu");
		list.add("qq");
		return new ReadOnlyList<>(list);
	}

	/*
	JDK内置list
	 */
	static List<String> getData12() {
		List<String> list = new ArrayList<>();
		list.add("abc");
		list.add("123");
		list.add("f708");
		list.add("ncepu");
		list.add("qq");

        /*
        //Sy
        Collections.synchronizedList(list); 转化为线程安全的list  内部实现了

        static class synchronized () 内部类，进行了代码块同步的过程
         */
		return Collections.unmodifiableList(list);
	}

	public static void main(String[] args) {

		List<String> list = getData();

		Iterator<String> it = list.iterator();
		it.next();
		it.remove();

		Iterator<String> it1 = it;
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}

		List<String> list2 = getData12();
		for (String s : list2) {
			System.out.println(s);
		}

	}
}
