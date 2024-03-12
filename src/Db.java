import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Db {
    private static final String JDBC_URL = Credential.JDBC_URL;
    private static final String USERNAME = Credential.USERNAME;
    private static final String PASSWORD = Credential.PASSWORD;

    static Connection connection;
    public static Connection connect()
    {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
