package com.f708.factoryMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBConnectionFactory implements IConnectionFactory{

    @Override
    public Connection create(String serverName, String dbName, String userName, String password) throws SQLException {
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
}
