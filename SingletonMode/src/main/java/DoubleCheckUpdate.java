import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: DoubleCheckUpdate.java
 * @Description: 三次检查   增加一次构造函数检查，防止反射注入，但是如果对方使用反编译，找到对应的field 照样可以新建，或者
 * @Package PACKAGE_NAME
 * @Time: 2021-03-31 21:08
 */
public class DoubleCheckUpdate {
    private static DoubleCheckUpdate dcu;

    /**
     * 加入一个标志位, 甚至可以把这个变量加密
     * 破解办法： 先获取field ，然后设置这个field access为false，把该字段值修改了，即可创建了
     *
     * Field light1 =  DoubleCheckUpdate.getDeclaredField("light");
     * light1.setAccessible(true);
     * light1.set(instanceBefore,false);
     */
    private static boolean light = false;

    private DoubleCheckUpdate(){
        /**
         * 解决先调用getInstance 后用反射生成对象的问题
         * 但是如果都用反射生成对象？
         */
        synchronized(DoubleCheckUpdate.class){
            if(DoubleCheckUpdate.class !=null){
                if (light==false) {
                    //为true的话 if就会跳到throw了！  这样可以进一步保证反射进行
                    light=true;
                }else{
                    throw new RuntimeException("不要试图使用反射产生对象");
                }

            }
        }

    }
    private static DoubleCheckUpdate getInstance(){

        if (dcu==null) {
            /**
             * 执行类锁  区分方法的对象锁  防止多线程出现多个问题
             */
            synchronized(DoubleCheckSingletonWithoutVolatile.class){
                if(dcu==null){
                    dcu = new DoubleCheckUpdate();
                }
            }
        }
        return dcu;
    }
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        /**
         * 先用正常方式生成 再用反射生成
         */
//        DoubleCheckUpdate test1 = DoubleCheckUpdate.getInstance();
//        Constructor<DoubleCheckUpdate> testConstr = DoubleCheckUpdate.class.getDeclaredConstructor(null);


        /**
         * 如果都用反射生成？
         */
        Constructor<DoubleCheckUpdate> testConstr = DoubleCheckUpdate.class.getDeclaredConstructor(null);
        /**
         * 设置为true 无视私有构造器
         */
        testConstr.setAccessible(true);
        DoubleCheckUpdate test1 = testConstr.newInstance();
        DoubleCheckUpdate test2 = testConstr.newInstance();
        System.out.println(test1);
        System.out.println(test2);
        /**
         * DoubleCheckUpdate@723279cf
         * DoubleCheckUpdate@10f87f48
         */
        /**
         * 如果是先用正常获得  再用反射获得对象---> 破解方法很简单，在构造函数中增加一个对应类是否为空的判断即可
         *
         *
         */
    }
}
