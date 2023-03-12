import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * DCL
 */
public class ThreeCheckSingleton {

    /**
     * volatile保证指令不重拍， 因为所有的对象生成一般都会经历三个步骤
     * 1. 向操作系统申请内存（分配内存空间）
     * 2. 执行构造方法，初始化对象
     * 3. 把这个对象指向这个空间
     *
     * 如果执行多线程，不加上volatile, 可能出现多个对象
     */
    private static volatile ThreeCheckSingleton singleton;

    private ThreeCheckSingleton() {
        synchronized (ThreeCheckSingleton.class){
            // 第三重检测  构造器检测
            // 但是解决不了 我如果都通过构造器字段创建对象？？？？
            // 也就是我根本就不经过singleton的字段初始化，那么其实singleton就一直为空了
            if(singleton != null){
                throw new RuntimeException("不要试图使用构造器反射创建实例");

            }
        }
        System.out.println(Thread.currentThread().getName()+"Ok");
    }

    public static ThreeCheckSingleton getInstance(){
        // 第一重检测
        if (singleton==null) {
            synchronized (ThreeCheckSingleton.class){
                //第二重检测
                if (singleton==null) {
                   singleton = new ThreeCheckSingleton(); // 仍存在问题,因为每次创建对象包含3个过程， 1. 分配对象空间，2. 执行构造方法 初始化对象 3. 把这个对象指向这个空间
                    //为此需要加入volatile 保证指令重排（也就是创建对象过程中 被引入其他操作）
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

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
        Constructor<ThreeCheckSingleton> declaredConstructor = ThreeCheckSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        ThreeCheckSingleton d1= declaredConstructor.newInstance();
        ThreeCheckSingleton d2= declaredConstructor.newInstance();

        System.out.println("d1 "+d1);
        System.out.println("d2 "+d2);

        // 也就是我们依然破解了三重检测
        System.out.println("ok, 三重检测依然无效  那么我们试试添加标志位");
    }
}
