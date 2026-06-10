import java.sql.*;

public class MySQLCRUD {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Customers";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "toor";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
