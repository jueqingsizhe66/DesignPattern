import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImplementReaderTemplate extends DBReaderTemplate {
	@Override
	protected Connection createConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/zszdb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
		Connection conn = DriverManager.getConnection(url, "root", "root");
		return conn;
	}

	@Override
	protected void processResultSet(ResultSet rs) throws SQLException {
		while (rs.next()) {
			String phone = rs.getString("phoneNum");
			System.out.println(phone);
		}

	}
}
