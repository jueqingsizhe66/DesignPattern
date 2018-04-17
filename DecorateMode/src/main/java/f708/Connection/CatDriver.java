package f708.Connection;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class CatDriver implements Driver {
	private Driver target;

	static {
		try {
            /*
            自己注册给DriverManager

            通过url格式是否accept? accept就是通过正则表达式进行编写的！！  新的url格式你认识？？？ 认识就调用自身的CatDriver
            如果不认识就报没有这个Driver
             */
			DriverManager.registerDriver(new CatDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		if (!acceptsURL(url)) {
			return null;
		}
		String[] segments = url.split("\\|");
		String targetDriver = segments[1];
		String targetUrl = segments[2];

		try {
			Class.forName(targetDriver); // 真正的jdbc方式 注册mysql驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.target = DriverManager.getDriver(targetUrl); // 真正jdbc方式获取
		Connection conn = DriverManager.getConnection(targetUrl, info);// 真正获取链接
		return new CatConnection(conn);
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		//jdbc:cat:|com.mysql.jdbc.Driver|jdbc:/mysql//localhost:3306...
		Pattern pattern = Pattern.compile("jdbc:cat:|(.+)?|(.+)");
		return pattern.matcher(url).matches();
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		return target.getPropertyInfo(url, info);
	}

	@Override
	public int getMajorVersion() {
		return target.getMajorVersion();
	}

	@Override
	public int getMinorVersion() {
		return target.getMinorVersion();
	}

	@Override
	public boolean jdbcCompliant() {
		return target.jdbcCompliant();
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return target.getParentLogger();
	}
}
