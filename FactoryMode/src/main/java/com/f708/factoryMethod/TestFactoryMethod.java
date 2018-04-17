package com.f708.factoryMethod;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 好处是增加新的子类，只要增加Factory类即可。坏处是调用者需要知道要创建哪个子类对象应该调用哪个Factory。
 * 坏处是需要记住具体的工厂
 */

/**
 如果工厂只创建一个产品，就是工厂方法模式，如果有多个产品需要创建，就在抽象接口、父类中声明多个createXXX方法。
 Java中的Connection接口就是应用了抽象工厂模式。Connection中的createStatement、prepareStatement、createClob等都是工厂方法。
 由具体子类实现接口。
 *
 */
public class TestFactoryMethod {
	public static void main(String[] args) throws SQLException {
		Connection conn = new MySqlConnectionFactory().create("127.0.0.1", "test", "root", "root");
	}
}
