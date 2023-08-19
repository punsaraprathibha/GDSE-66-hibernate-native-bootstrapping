package lk.ijse.gdse.orm.hibernate.service.impl;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.dto.CustomerDto;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import lk.ijse.gdse.orm.hibernate.repository.CustomerRepository;
import lk.ijse.gdse.orm.hibernate.repository.impl.CustomerRepositoryImpl;
import lk.ijse.gdse.orm.hibernate.service.CustomerService;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerServiceImpl implements CustomerService {

    private static CustomerServiceImpl customerService;
    private final CustomerRepository customerRepository;

    private CustomerServiceImpl() {
        customerRepository = (CustomerRepository) new CustomerRepositoryImpl();
    }

    public static CustomerServiceImpl getInstance() {
        return null == customerService
                ? customerService = new CustomerServiceImpl()
                : customerService;
    }

    @Override
    public int saveCustomer(CustomerDto customer) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            customerRepository.setSession(session);
            int customerId = customerRepository.saveCustomer(customer.toEntity());
            transaction.commit();
            session.close();
            return customerId;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public CustomerDto getCustomer(int id) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        try {
            customerRepository.setSession(session);
            Customer customer = customerRepository.getCustomer(id);
            session.close();
            return customer.toDto();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public boolean updateCustomer(CustomerDto customer) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            customerRepository.setSession(session);
            customerRepository.updateCustomer(customer.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(CustomerDto customer) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            customerRepository.setSession(session);
            customerRepository.deleteCustomer(customer.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

}
