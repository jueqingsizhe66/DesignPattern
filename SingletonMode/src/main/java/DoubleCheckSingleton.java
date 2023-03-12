import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * DCL
 */
public class DoubleCheckSingleton {

    /**
     * volatile保证指令不重拍， 因为所有的对象生成一般都会经历三个步骤
     * 1. 向操作系统申请内存（分配内存空间）
     * 2. 执行构造方法，初始化对象
     * 3. 把这个对象指向这个空间
     *
     * 如果执行多线程，不加上volatile, 可能出现多个对象
     */
    private static volatile DoubleCheckSingleton singleton;

    private DoubleCheckSingleton() {
        System.out.println(Thread.currentThread().getName()+"Ok");
    }

    public static DoubleCheckSingleton getInstance(){
        if (singleton==null) {
            synchronized (DoubleCheckSingleton.class){
                if (singleton==null) {
                   singleton = new DoubleCheckSingleton(); // 仍存在问题,因为每次创建对象包含3个过程， 1. 分配对象空间，2. 执行构造方法 初始化对象 3. 把这个对象指向这个空间
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
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                DoubleCheckSingleton.getInstance();
            }).start();

        }

        DoubleCheckSingleton d1 =  DoubleCheckSingleton.getInstance();
        Constructor<DoubleCheckSingleton> declaredConstructor = DoubleCheckSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        DoubleCheckSingleton d2= declaredConstructor.newInstance();

        System.out.println("d1 "+d1);
        System.out.println("d2 "+d2);

    }
}
