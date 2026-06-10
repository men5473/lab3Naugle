import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        /// Created three customers
        Customer customer1 = new Customer(1, "Joe", "Smith", "0001 Main Ave",
                new Date(2001, 01, 01), "js010101@gmail.com", "1111111111");
        Customer customer2 = new Customer(2, "Jane", "Smith", "0002 Main Ave",
                new Date(2002, 02, 02), "js020202@gmail.com", "2222222222");
        Customer customer3 = new Customer(3, "Jack", "Smith", "0003 Main Ave",
                new Date(2003, 03, 03), "js030303@gmail.com", "3333333333");


        ///mysql CRUD start
        Connection connection = MySQLCRUD.openSQL();

        ///adding three customers to db
        MySQLCRUD.insertCustomer(connection, customer1.getId(), customer1.getFirstName(), customer1.getLastName(),
                customer1.getAddress(), customer1.getDob(), customer1.getEmail(), customer1.getPhone());
        MySQLCRUD.insertCustomer(connection, customer2.getId(), customer2.getFirstName(), customer2.getLastName(),
                customer2.getAddress(), customer2.getDob(), customer2.getEmail(), customer2.getPhone());
        MySQLCRUD.insertCustomer(connection, customer3.getId(), customer3.getFirstName(), customer3.getLastName(),
                customer3.getAddress(), customer3.getDob(), customer3.getEmail(), customer3.getPhone());

        ///getting customer list from db
        List<Customer> customers = MySQLCRUD.getAllCustomer(connection);

        ///updating customers in db
        MySQLCRUD.updateCustomer(connection, customer1.getId(), "John");
        MySQLCRUD.updateCustomer(connection, customer2.getId(), "Juliet");
        MySQLCRUD.updateCustomer(connection, customer3.getId(), "Jax");

        ///deleting customers in db
        MySQLCRUD.deleteCustomer(connection, customer1.getId());
        MySQLCRUD.deleteCustomer(connection, customer2.getId());
        MySQLCRUD.deleteCustomer(connection, customer3.getId());


        ///mongodb CRUD start
        MongoCollection<Document> collection = MongoCRUD.openMongo();

        ///adding three customers to db
        MongoCRUD.insertCustomer(collection, customer1.getId(), customer1.getFirstName(), customer1.getLastName(),
                customer1.getAddress(), customer1.getDob(), customer1.getEmail(), customer1.getPhone());
        MongoCRUD.insertCustomer(collection, customer2.getId(), customer2.getFirstName(), customer2.getLastName(),
                customer2.getAddress(), customer2.getDob(), customer2.getEmail(), customer2.getPhone());
        MongoCRUD.insertCustomer(collection, customer3.getId(), customer3.getFirstName(), customer3.getLastName(),
                customer3.getAddress(), customer3.getDob(), customer3.getEmail(), customer3.getPhone());

        ///getting customer docs from db
        FindIterable<Document> findIterable = MongoCRUD.getAllCustomer(collection);

        ///updating customers in db
        MongoCRUD.updateCustomer(collection, customer1.getId(), "John");
        MongoCRUD.updateCustomer(collection, customer2.getId(), "Juliet");
        MongoCRUD.updateCustomer(collection, customer3.getId(), "Jax");

        ///deleting customers in db
        MongoCRUD.deleteCustomer(collection, customer1.getId());
        MongoCRUD.deleteCustomer(collection, customer2.getId());
        MongoCRUD.deleteCustomer(collection, customer3.getId());
    }
}
