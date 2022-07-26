package DBConnection.Customer;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Customer implements Serializable {
    private int id;
    private String name;
    private Date yob;

    public Customer() {
    }
    public Customer(int id, String name, Date yob) {
        this.id = id;
        this.name = name;
        this.yob = yob;
    }

    Calendar calendar = Calendar.getInstance();


    @Override
    public String toString() {
        return "Customer {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                '}';
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Date getYob() {
        return yob;
    }
    public void setYob(Date yob) {
        this.yob = yob;
    }
}
