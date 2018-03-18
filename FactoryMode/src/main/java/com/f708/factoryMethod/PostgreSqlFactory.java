package com.f708.factoryMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSqlFactory implements IConnectionFactory {
    @Override
    public Connection create(String serverName, String dbName, String userName, String password) throws SQLException {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        String url = "jbdc:postgresql://"+serverName+":5432/"+dbName;
        return DriverManager.getConnection(url,userName,password);
    }

}
