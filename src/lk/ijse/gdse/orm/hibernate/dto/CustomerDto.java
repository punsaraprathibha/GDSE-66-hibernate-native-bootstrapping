package lk.ijse.gdse.orm.hibernate.dto;

import lk.ijse.gdse.orm.hibernate.entity.Customer;

public class CustomerDto {

    private int id;
    private String name;
    private String address;
    private int age;
    private double salary;

    public CustomerDto() {}

    public CustomerDto(int id, String name, String address, int age, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.salary = salary;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Customer toEntity() {
        Customer customer = new Customer();
        customer.setId(this.id);
        customer.setName(this.name);
        customer.setAddress(this.address);
        customer.setAge(this.age);
        customer.setSalary(this.salary);
        return customer;
    }
}
