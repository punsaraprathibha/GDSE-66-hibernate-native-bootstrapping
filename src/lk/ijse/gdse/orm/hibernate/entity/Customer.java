package lk.ijse.gdse.orm.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//1. 1st way to define table name => @Entity(name = "customer")
//2. 2nd way to define table name =>
//   @Entity
//   @Table(name = "customer")
@Entity
@Table(name = "customer")
public class Customer {

    @Id // Tells hibernate that this is the primary key of this entity
    @Column(name = "customer_id") // defines how the column name should be generated in database
    private int id;
    @Column(name = "customer_name")
    private String name;
    @Column(name = "customer_address")
    private String address;
    @Column(name = "customer_salary")
    private double salary;

    /**
     * Default Constructor
     */
    public Customer() {}

    /**
     * @param id : long
     * @param name : java.lang.String
     * @param address : java.lang.String
     * @param salary : double
     * All Args Constructor
     */
    public Customer(int id, String name, String address, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    /**
     * @return int
     */
    public long getId() {
        return id;
    }

    /**
     * @param id : int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return java.lang.String
     */
    public String getName() {
        return name;
    }

    /**
     * @param name : java.lang.String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return java.lang.String
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address : java.lang.String
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return double
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary : double
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }


    /**
     * @return java.lang.String
     */
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
