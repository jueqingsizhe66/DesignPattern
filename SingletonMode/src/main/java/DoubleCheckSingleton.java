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
    }

    public static DoubleCheckSingleton getInstance(){
        if (singleton==null) {
            synchronized (DoubleCheckSingleton.class){
                if (singleton==null) {
                   singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {

    }
}
