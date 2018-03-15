package com.datasourceReal;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PooledConnectionFactory  implements PooledObjectFactory<Connection> {
    private String dbUrl;
    private String userName;
    private String password;
    public PooledConnectionFactory(String driverName, String dbUrl, String userName, String password) {
        super();
        this.dbUrl = dbUrl;
        this.userName = userName;
        this.password = password;

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PooledObject<Connection> makeObject() throws Exception {
        System.out.println("没有可用数据库连接，开始创建");
        Connection conn = DriverManager.getConnection(dbUrl,userName,password);
        return new DefaultPooledObject<Connection>(conn);

    }

    @Override
    public void destroyObject(PooledObject<Connection> pooledObject) throws Exception {
        System.out.println("销毁对象");
        pooledObject.getObject().close();
    }

    @Override
    public boolean validateObject(PooledObject<Connection> pooledObject) {
        try {
            return pooledObject.getObject().isClosed()==false;
        } catch (SQLException e) {
            return false;
        }

    }

    @Override
    public void activateObject(PooledObject<Connection> pooledObject) throws Exception {

    }

    @Override
    public void passivateObject(PooledObject<Connection> pooledObject) throws Exception {

    }
}
