package com.datasourceReal;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestDataSourceReal {
    public static void main(String[] args) {
        PooledConnectionFactory fac = new PooledConnectionFactory("com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT", "root", "root");
        GenericObjectPoolConfig conf = new GenericObjectPoolConfig();
        /*
        尽可能复用对象，复用池中东西， 复用sockets等
         */
        conf.setMaxTotal(10);
        conf.setMaxIdle(3);
        GenericObjectPool<Connection> pool = new GenericObjectPool<Connection>(fac, conf);

        for(int i=0;i<1000;i++)
        {
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    Connection conn = null;
                    try {
                        conn = pool.borrowObject();
                        //try(PreparedStatement ps = conn.prepareStatement("insert into t_dog(name) values('san')"))
                        /*
                        得用？形势插入，才可以不带id(数据库是id-name)

                        id设置为主键 ，auto_increment.
                         */
                        try(PreparedStatement ps = conn.prepareStatement("insert into t_dog(name) values(?)");)
                        {
                            String id=String.valueOf(Thread.currentThread().getId());
                            ps.setString(1,id);
                            ps.executeUpdate();
                            System.out.println("插入完成");
                        }
                        System.out.println(conn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    finally
                    {
                        pool.returnObject(conn);
                    }
                }
            });
            t.start();
        }


    }
}
