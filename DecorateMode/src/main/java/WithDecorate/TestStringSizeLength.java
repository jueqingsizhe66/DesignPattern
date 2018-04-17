package WithDecorate;

import java.util.LinkedList;
import java.util.List;

public class TestStringSizeLength {
	public static void main(String[] args) {
		List<String> list = new SizeLimitList<>(new LinkedList<>(), 10);

        /*
        此种方式类似于访问者模式的教程   new ---new ----new
        也类似于函数式编程的特点
       http://a-little-java-a-few-patterns.readthedocs.io/zh_CN/latest/

       装饰器分层，装饰器只干一层功能(最大好处)
         */
		List<String> list2 = new StringLenLimitList(new SizeLimitList<>(new LinkedList<>(), 10));
	}
}
