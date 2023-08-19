package lk.ijse.gdse.orm.hibernate.service;

import lk.ijse.gdse.orm.hibernate.dto.CustomerDto;
import lk.ijse.gdse.orm.hibernate.entity.Customer;

public interface CustomerService {

    int saveCustomer(CustomerDto customer);

    CustomerDto getCustomer(int id);

    boolean updateCustomer(CustomerDto customer);

    boolean deleteCustomer(CustomerDto customer);
}
