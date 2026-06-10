import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class MySQLCRUD {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Customers";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "toor";

    public static Connection openSQL() {
        Connection connection = null;
        try {
            return connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return connection;
        }
    }

    public static void insertCustomer(Connection connection, int id, String firstName, String lastName, String address,
                                       Date dob, String email, String phone) throws SQLException {
        String sql = "INSERT INTO Customers (id, firstName, lastName, address, dob, email, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, address);
            preparedStatement.setDate(5, new java.sql.Date(dob.getTime()));
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, phone);
            preparedStatement.executeUpdate();
        }
    }

    public static List<Customer> getAllCustomer(Connection connection) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT id, firstName, lastName, address, dob, email, phone FROM customers";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                Date dob = resultSet.getDate("dob");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                customers.add(new Customer(id, firstName, lastName, address, dob, email, phone));
            }
        }
        return customers;
    }

    public static void updateCustomer(Connection connection, int id, String newFirstName) throws SQLException {
        String sql = "UPDATE customers SET firstName = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newFirstName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
    }

    public static void deleteCustomer(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM customers WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
