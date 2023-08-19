package lk.ijse.gdse.orm.hibernate.service;

import lk.ijse.gdse.orm.hibernate.entity.Customer;

public interface CustomerService {

    int saveCustomer(Customer customer);

    Customer getCustomer(int id);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomer(Customer customer);
}
