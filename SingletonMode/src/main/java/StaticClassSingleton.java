public class StaticClassSingleton {
    // 推荐使用
    private static StaticClassSingleton instance;

    //构造器私有化(所有单例模式都有）
    private StaticClassSingleton(){
    }

    //静态内部类， 只在使用的时候才加载
    private static class SingletonInstance{
        //保证线程安全
        private static final StaticClassSingleton INSTANCE= new StaticClassSingleton();
    }

    //提供一个静态公开方法

    public static synchronized StaticClassSingleton getInstance(){
        return SingletonInstance.INSTANCE;
    }


}
