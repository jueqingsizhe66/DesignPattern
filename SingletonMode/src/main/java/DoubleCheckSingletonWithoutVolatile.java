/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: DoubleCheckSingletonWithoutVolatile.java
 * @Description: 测试多线程执行不带volatile DCL单例 ,结果未发现太多问题
 * @Package PACKAGE_NAME
 * @Time: 2021-03-31 20:45
 */
public class DoubleCheckSingletonWithoutVolatile {
    private DoubleCheckSingletonWithoutVolatile() {
        /**
         * 只会执行一次输出  只会进行一次构造
         */
        System.out.println("构造器通知"+Thread.currentThread().getName()+"-->ok!");
    }

    private static DoubleCheckSingletonWithoutVolatile dcs ;

    /**
     * 通过该方法获取单例
     * @return
     */
    public static DoubleCheckSingletonWithoutVolatile getInstance(){
        if (dcs==null) {
            /**
             * 执行类锁  区分方法的对象锁  防止多线程出现多个问题
             */
            synchronized(DoubleCheckSingletonWithoutVolatile.class){
                if(dcs==null){
                    dcs = new DoubleCheckSingletonWithoutVolatile();
                }
            }
        }
        return dcs;
    }

    public static void main(String[] args) {
        /**
         * 枷锁之后保证单例
         */
        for (int application = 0; application < 1000; application++) {
            int finalApplication = application;
            new Thread(()->{
                DoubleCheckSingletonWithoutVolatile dp = DoubleCheckSingletonWithoutVolatile.getInstance();
                System.out.println(Thread.currentThread().getName()+"--->"+ finalApplication+" generates "+dp);
            },String.valueOf(finalApplication)).start();
        }
    }

}
