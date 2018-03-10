public class TestString {
    public static void main(String[] args) {
        /*
英文名称：Flyweight Pattern。
	享元模式的目的就是为了降低内存的占用，对于同样用途的对象，尽可能复用同一个对象。享元模式没有固定的实现套路，而且一般是语言平台层面的，项目开发层面比较少用到。所以这里直接分析JDK中的享元模式的应用。
	共享的对象通常具有不可变性，这样避免公用一个对象的并发修改问题。
	复习：Java中==是用来比较是否同一个引用对象。

         */
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc"); // new 强制不在字符串常量池
        System.out.println(s1==s2);//true
        System.out.println(s1==s3);//false

    }
}
