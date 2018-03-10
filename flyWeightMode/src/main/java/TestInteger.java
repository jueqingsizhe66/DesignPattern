public class TestInteger {
   /*
i1、i2引用的是同一个对象；b1、b2引用的不是同一个对象。
	因为Integer i1 = 6编译器会搞成Integer i1=Integer.valueOf(6)，所以看一下public static Integer valueOf(int i)的代码了解一下原理：
public static Integer valueOf(int i) {
	if (i >= IntegerCache.low && i <= IntegerCache.high)
		return IntegerCache.cache[i + (-IntegerCache.low)];
	return new Integer(i);
}
	我们发现在[-128,127]之间的数会复用IntegerCache中的对象。程序中[-128,127]中的数用的很多，当对他们进行装箱的时候很显然可以降低内存中Integer对象的个数。

    */
    public static void main(String[] args) {
        Integer i1 = 6 ;
        Integer i2 = 6 ;
        System.out.println(i1 == i2);//true

        Integer b1 = 128 ;
        Integer b2 = 128 ;
        System.out.println(b1 == b2);//false

    }
}
