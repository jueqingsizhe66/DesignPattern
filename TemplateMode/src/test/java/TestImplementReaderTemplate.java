import java.sql.SQLException;

public class TestImplementReaderTemplate {
    public static void main(String[] args) {

        ImplementReaderTemplate db = new ImplementReaderTemplate();
        try {
            db.executeQuery("select * from t_users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
