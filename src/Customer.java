/**

 * Project: Solo Lab 3 Database Assignment MySQL and MongoDB Perform CRUD Create. Read, Update and Delete
 * Purpose Details: Customer object
 * Course: IST 242
 * Author: Martin Naugle
 * Date Developed: 06/09/2026
 * Last Date Changed: 06/09/2026
 * Revision:

 */
import java.util.Date;

public class Customer {
    private int id;/// id
    private String firstName;/// first name
    private String lastName;/// last name
    private String address;/// #### street name
    private Date dob;/// month/day/year
    private String email;/// name@address.xxx
    private String phone;/// ###-###-#####

    ///default constructor
    public Customer() {
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.address = "";
        this.dob = null;
        this.email = "";
        this.phone = "";
    }

    ///constructor with parameters that reflect the Customer's variables
    public Customer(int id, String firstName, String lastName, String address, Date dob, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }

    ///getter & setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    ///getter & setter for first name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    ///getter & setter for last name
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    ///getter & setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    ///getter & setter for dob
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    ///getter & setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    ///getter & setter for phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
