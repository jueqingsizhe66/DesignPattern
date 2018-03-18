public class LanHanshi {
    private static LanHanshi instance = null;

    /**
     * 区分于饿汉式
     */
    public LanHanshi(){

    }

    public static LanHanshi getInStanc() {
        if (instance == null) //如果为空则创建
        {
            synchronized (LanHanshi.class) // 进入同步代码快
            {
                if (instance == null) // Double Check 方式
                {
                    instance = new LanHanshi();
                }
            }
        }
        return instance;
    }
}

