package com.datasource;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class PooledMyConnectionFactory implements PooledObjectFactory<MyConnection>{
    @Override
    public PooledObject<MyConnection> makeObject() throws Exception {
        System.out.println("开始创建新的MyCOnnection 对象");
        MyConnection conn = new MyConnection();
        System.out.println("Finished creating MyConnection");
        return new DefaultPooledObject<MyConnection>(conn);
    }

    @Override
    public void destroyObject(PooledObject<MyConnection> pooledObject) throws Exception {
        System.out.println("开始销毁链接"); //打印出来
        pooledObject.getObject().close();
    }

    @Override
    public boolean validateObject(PooledObject<MyConnection> pooledObject) {
        return pooledObject.getObject().isClosed()==false;
    }

    @Override
    public void activateObject(PooledObject<MyConnection> pooledObject) throws Exception {

    }

    @Override
    public void passivateObject(PooledObject<MyConnection> pooledObject) throws Exception {

    }
}
