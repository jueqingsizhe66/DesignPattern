import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DBReaderTemplate {
	protected abstract Connection createConnection() throws SQLException;

	protected abstract void processResultSet(ResultSet rs) throws SQLException;


	public void executeQuery(String sql, Object... params) throws SQLException {
		try (Connection conn = createConnection();) {
			try (PreparedStatement ps = conn.prepareStatement(sql);) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
				try (ResultSet rs = ps.executeQuery();) {
					processResultSet(rs);
				}

			}
		}


	}

}
