import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;


/**
 * DCL
 */
public class ThreeCheckSingletonWithSign {

    /**
     * volatile保证指令不重拍， 因为所有的对象生成一般都会经历三个步骤
     * 1. 向操作系统申请内存（分配内存空间）
     * 2. 执行构造方法，初始化对象
     * 3. 把这个对象指向这个空间
     *
     * 如果执行多线程，不加上volatile, 可能出现多个对象
     */
    private static volatile ThreeCheckSingletonWithSign singleton;
    // 只有内部人员才知道的标志位！ 但是也可能被反编译检测到，道高一尺魔高一丈！
    //如果yzl不是静态字段 那么yzl无效  必须是静态字段, 他才能被初始化 否则一直是false状态
    private static Boolean yzl=false;

    private ThreeCheckSingletonWithSign() {
        synchronized (ThreeCheckSingletonWithSign.class){
            // 第三重检测  构造器检测
            // 但是解决不了 我如果都通过构造器字段创建对象？？？？
            // 也就是我根本就不经过singleton的字段初始化，那么其实singleton就一直为空了
            if(yzl == false){
                yzl = true;
            }else{
                throw new RuntimeException("不要试图使用构造器反射创建实例");
            }
        }
        System.out.println(Thread.currentThread().getName()+"  Ok");
    }

    public static ThreeCheckSingletonWithSign getInstance(){
        // 第一重检测
        if (singleton==null) {
            synchronized (ThreeCheckSingletonWithSign.class){
                //第二重检测
                if (singleton==null) {
                   singleton = new ThreeCheckSingletonWithSign(); // 仍存在问题,因为每次创建对象包含3个过程， 1. 分配对象空间，2. 执行构造方法 初始化对象 3. 把这个对象指向这个空间
                    //为此需要加入volatile 保证指令重排（也就是创建对象过程中 被引入其他操作）
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        /**
         * DCL目前是没问题的
         * 也加入了volatile防止指令重排， 但是一碰到反射，那么private都是没用的，都可以创建出来一个新的示例
         */
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                ThreeCheckSingleton.getInstance();
//            }).start();
//
//        }

        //如果我这个也采用构造器反射进行对象创建呢？  我只要没有调用过ThreeCheckSingleton.getInstance()函数就好，也就是我没有初始化singleton字段就好
//        ThreeCheckSingleton d1 =  ThreeCheckSingleton.getInstance();
        Field yzl = ThreeCheckSingletonWithSign.class.getDeclaredField("yzl");
        yzl.setAccessible(true);
        Constructor<ThreeCheckSingletonWithSign> declaredConstructor = ThreeCheckSingletonWithSign.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        ThreeCheckSingletonWithSign d1= declaredConstructor.newInstance();
        // 注意 看看这部注入过程，字段类反射之后，可以重新设置生成类的yzl字段为false， 这样就可以一直生成新的字段了
        yzl.set(d1,false);
        ThreeCheckSingletonWithSign d2= declaredConstructor.newInstance();

        System.out.println("d1 "+d1);
        System.out.println("d2 "+d2);

        // 也就是我们依然破解了三重检测
        System.out.println("ok, 三重检测依然无效  那么我们试试添加标志位");
        /**
         * Exception in thread "main" java.lang.reflect.InvocationTargetException
         * 	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
         * 	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:77)
         * 	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
         * 	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)
         * 	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:480)
         * 	at ThreeCheckSingletonWithSign.main(ThreeCheckSingletonWithSign.java:70)
         * Caused by: java.lang.RuntimeException: 不要试图使用构造器反射创建实例
         * 	at ThreeCheckSingletonWithSign.<init>(ThreeCheckSingletonWithSign.java:31)
         * 	... 6 more
         */
        // 的确添加了标志位yzl 有效，但是我依然可以用反编译  确认有一个反射字段叫做yzl， 然后我设置yzl为可访问，修改他的属性为false，依然是可以生成的
        System.out.println("ok， 虽然添加了yzl字段，但是依然可以通过反射获取该字段类，并且设置已生成对象的yzl属性为false，这样就可以不断生成了， 还是防不胜防");
    }
}
