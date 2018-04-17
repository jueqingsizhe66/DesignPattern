package com.f708.factoryMethod;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionFactory {
	Connection create(String serverName, String dbName, String userName, String password) throws SQLException;
}
