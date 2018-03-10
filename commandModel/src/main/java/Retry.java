import java.sql.Connection;
import java.sql.DriverManager;

public class Retry {
    public static boolean execute(int maxTimes, RetryRunnable task)
    {
        for (int i = 0; i < maxTimes; i++) {
            try {
                task.run();
                return true;
            }catch (Exception ex)
            {
                System.out.println("The"+(i+1)+"st failed" +ex.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = Retry.execute(3, new RetryRunnable() {
           /* public void run() throws Exception {
                URL url = new URL("http://www.rupeng.com");
                String html= IOUtils.toString(url,"UTF-8");
                System.out.println(html);
                System.out.println(html.substring(0,20));
            }*/

            /*public void run() throws Exception{
                 URL url = new URL("http://w3w.rupeng.com");
                String html= IOUtils.toString(url,"UTF-8");
//                System.out.println(html);
                System.out.println(html.substring(0,20));
            }*/

            public void run() throws Exception{
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://192.168.0.99:3306/zsd?Unicode=true&charcterEncoding=UTF-8&serverTimezone=GMT";
                Connection conn = DriverManager.getConnection(url,"root","root");
                conn.prepareStatement("select * from t_users");
                System.out.println("ok");


            }
        });
    }
}
