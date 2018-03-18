import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 简单工厂模式
 * 项目中有不同的子类，我们会根据情况创建不同的子类对象，这时候就创建一个类，方法中做if判断，创建不同子类。
 * 简单工厂模式的优点是我们只要传递不同的参数就可以拿到合适的子类对象，不用关心对象怎么来的。
 简单工厂模式的缺点是如果增加新的子类，还要增加新的if子句。

 */
public class SimpleFactory {
    public Connection createConnection(String dbType, String serverName, String dbName, String userName, String password) throws SQLException
    {
        if(dbType.equalsIgnoreCase("mysql"))
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e)
            {
                throw new RuntimeException(e);
            }
            String url = "jdbc:mysql://"+serverName+":3306/"+dbName
                    +"?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
            return DriverManager.getConnection(url,userName,password);
        }
        else if(dbType.equalsIgnoreCase("postgresql"))
        {
            try
            {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e)
            {
                throw new RuntimeException(e);
            }
            String url = "jbdc:postgresql://"+serverName+":5432/"+dbName;
            return DriverManager.getConnection(url,userName,password);
        }
        else if(dbType.equalsIgnoreCase("MariaDB"))
        {
            try
            {
                Class.forName("org.mariadb.jdbc.Driver");
            } catch (ClassNotFoundException e)
            {
                throw new RuntimeException(e);
            }
            String url = "jdbc:mariadb://"+serverName+":3306/"+dbName;
            return DriverManager.getConnection(url,userName,password);
        }
        else
        {
            throw new IllegalArgumentException("未知的dbType参数类型");
        }
    }

}
