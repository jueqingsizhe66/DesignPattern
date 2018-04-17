package f708.Connection;

import java.sql.*;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test?Unicode=true&charcterEncoding=UTF-8&serverTimezone=GMT";
        try(
            Connection conn = DriverManager.getConnection(url,"root","root");
            Connection conn1 = new CatConnection(conn);

            PreparedStatement ps =conn1.prepareStatement("select * from apple");
            //conn.prepareStatement("select * from t_users");
            ResultSet rs = ps.executeQuery();
            PreparedStatement ps1 =conn1.prepareStatement("delete from apple");

        ){
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
            }
            ps1.execute();
        }*/
		Class.forName("f708.Connection.CatDriver");
		String url = "jdbc:cat:|com.mysql.jdbc.Driver|jdbc:mysql://localhost:3306/test?Unicode=true&charcterEncoding=UTF-8&serverTimezone=GMT";
		try (
				Connection conn = DriverManager.getConnection(url, "root", "root");
				Connection conn1 = new CatConnection(conn);

				PreparedStatement ps = conn1.prepareStatement("select * from apple");
				//conn.prepareStatement("select * from t_users");
				ResultSet rs = ps.executeQuery();
				PreparedStatement ps1 = conn1.prepareStatement("delete from apple");

		) {
			while (rs.next()) {
				System.out.println(rs.getInt("id"));
			}
			ps1.execute();
		}
	}
}
