import java.util.Date;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private Date dob;
    private String email;
    private String phone;

    public Customer() {
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.address = "";
        this.dob = null;
        this.email = "";
        this.phone = "";
    }

    public Customer(int id, String firstName, String lastName, String address, Date dob, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
