/**

 * Project: Solo Lab 3 Database Assignment MySQL and MongoDB Perform CRUD Create. Read, Update and Delete
 * Purpose Details: mongo CRUD
 * Course: IST 242
 * Author: Martin Naugle
 * Date Developed: 06/09/2026
 * Last Date Changed: 06/09/2026
 * Revision:

 */
import com.mongodb.client.*;
import org.bson.Document;

import java.util.Date;

public class MongoCRUD {
    ///opens mongo database
    public static MongoCollection<Document> openMongo() {
        // Create a MongoClient using the factory method
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // Access the database and collection
            MongoDatabase database = mongoClient.getDatabase("Customers");
            return database.getCollection("customers");
        }
    }

    ///adds customer to the mongo db w/ a document
    public static void insertCustomer(MongoCollection<Document> collection, int id, String firstName, String lastName,
                                      String address, Date dob, String email, String phone) {
        Document newCustomer = new Document("id", id)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("address", address)
                .append("dob", dob)
                .append("email", email)
                .append("phone", phone);
        collection.insertOne(newCustomer);
    }

    ///gets all the customers from the db
    public static FindIterable<Document> getAllCustomer(MongoCollection<Document> collection) {
        return collection.find();
    }


    ///updates customer's first name in db
    public static void updateCustomer(MongoCollection<Document> collection, int id, String firstName) {
        Document newCustomer = new Document("$set", new Document("firstName", firstName));
        collection.updateOne(new Document("id", id), newCustomer);
    }

    ///deletes customer from db
    public static void deleteCustomer(MongoCollection<Document> collection, int id) {
        collection.deleteOne(new Document("id", id));
    }
}
