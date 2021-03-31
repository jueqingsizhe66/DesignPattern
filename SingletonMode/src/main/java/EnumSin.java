import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: EnumSin.java
 * @Description: 通过枚举创建单例
 * @Package PACKAGE_NAME
 * @Time: 2021-03-31 21:33
 */
public enum EnumSin {

    INSTANCE;

    public EnumSin getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSin es1 = EnumSin.INSTANCE;
//        EnumSin es2 = EnumSin.INSTANCE;

//        Constructor<EnumSin> enuCon = EnumSin.class.getDeclaredConstructor(null);
        Constructor<EnumSin> enuCon = EnumSin.class.getDeclaredConstructor(String.class,int.class);
        enuCon.setAccessible(true);
        EnumSin es2 = enuCon.newInstance();
        System.out.println(es1);
        System.out.println(es2);
        /**
         * Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
         * 	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:493)
         * 	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:481)
         * 	at EnumSin.main(EnumSin.java:27)
         */
    }

    /** javap -p EnumSim.class
     * 得到下面结果  知道EnumSin也是一个class,但是他的确是有无参构造器，为什么还不行，我们被骗了，于是使用更专业的工具 jad.exe
     Compiled from "EnumSin.java"
     public final class EnumSin extends java.lang.Enum<EnumSin> {
     public static final EnumSin INSTANCE;
     private static final EnumSin[] $VALUES;
     public static EnumSin[] values();
     public static EnumSin valueOf(java.lang.String);
     private EnumSin();
     public EnumSin getInstance();
     public static void main(java.lang.String[]) throws java.lang.NoSuchMethodException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, jav
     a.lang.InstantiationException;
     static {};
     }
     *
     */

    /**
     * jad -sjava EnumSin.class
     // Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
     // Jad home page: http://www.kpdus.com/jad.html
     // Decompiler options: packimports(3)
     // Source File Name:   EnumSin.java

     import java.io.PrintStream;
     import java.lang.reflect.Constructor;
     import java.lang.reflect.InvocationTargetException;

     public final class EnumSin extends Enum
     {

     public static EnumSin[] values()
     {
     return (EnumSin[])$VALUES.clone();
     }

     public static EnumSin valueOf(String name)
     {
     return (EnumSin)Enum.valueOf(EnumSin, name);
     }
     //注意并非无参构造器  他是有参的
     private EnumSin(String s, int i)
     {
     super(s, i);
     }

     public EnumSin getInstance()
     {
     return INSTANCE;
     }

     public static void main(String args[])
     throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
     {
     EnumSin es1 = INSTANCE;
     Constructor enuCon = EnumSin.getDeclaredConstructor(null);
     enuCon.setAccessible(true);
     EnumSin es2 = (EnumSin)enuCon.newInstance(new Object[0]);
     System.out.println(es1);
     System.out.println(es2);
     }

     public static final EnumSin INSTANCE;
     private static final EnumSin $VALUES[];

     static
     {
     INSTANCE = new EnumSin("INSTANCE", 0);
     $VALUES = (new EnumSin[] {
     INSTANCE
     });
     }
     }
     *
     */
}
