import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class testThreadPoolExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.execute(new Runnable() {
            public void run() {
                System.out.println(new Date() + "execute！");
            }
        });
    }
}
