import com.mongodb.client.*;
import org.bson.Document;

import java.util.Date;

public class MongoCRUD {
    public static MongoCollection<Document> openMongo() {
        // Create a MongoClient using the factory method
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // Access the database and collection
            MongoDatabase database = mongoClient.getDatabase("Customers");
            return database.getCollection("customers");
        }
    }

            // Example: Insert a document
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

            // Read
    public static FindIterable<Document> getAllCustomer(MongoCollection<Document> collection) {
        return collection.find();
    }


            // Update
    public static void updateCustomer(MongoCollection<Document> collection, int id, String firstName) {
        Document newCustomer = new Document("$set", new Document("firstName", firstName));
        collection.updateOne(new Document("id", id), newCustomer);
    }

            // Delete
    public static void deleteCustomer(MongoCollection<Document> collection, int id) {
        collection.deleteOne(new Document("id", id));
    }
}
