package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.entity.Customer;
import lk.ijse.gdse.orm.hibernate.entity.Order;
import lk.ijse.gdse.orm.hibernate.projection.CustomerProjection;
import lk.ijse.gdse.orm.hibernate.repository.impl.CustomerRepositoryImpl;

import java.util.List;

public class SqlQueryEvaluator {

    public static void main(String[] args) {

        System.out.println("------JPQL Get All-----------");
        CustomerRepositoryImpl customerRepositoryImpl = new CustomerRepositoryImpl();
        List<Customer> allCustomerNative = customerRepositoryImpl.getAllCustomerJPQL();
        for (Customer customer : allCustomerNative) {
            System.out.println(customer);
        }

        System.out.println("----------JPQL Where--------");
        CustomerRepositoryImpl customerRepositoryImpl1 = new CustomerRepositoryImpl();
        Customer customerById = customerRepositoryImpl1.getCustomerById(1);
        System.out.println(customerById);

        System.out.println("---------JPQL JOIN-------");

        CustomerRepositoryImpl customerRepositoryImpl2 = new CustomerRepositoryImpl();
        List<Order> orders = customerRepositoryImpl2.getOrdersByCustomerId(1);
        for (Order order : orders) {
            System.out.println(order);
        }

        System.out.println("---------HQL Get All-------");

        CustomerRepositoryImpl customerRepositoryImpl3 = new CustomerRepositoryImpl();
        List<Customer> customersHQL = customerRepositoryImpl3.getCustomersHQL();
        for (Customer customer : customersHQL) {
            System.out.println(customer);
        }

        System.out.println("-------Customer JPQL Projection----");

        CustomerRepositoryImpl customerRepositoryImpl4 = new CustomerRepositoryImpl();
        List<CustomerProjection> customerProjection = customerRepositoryImpl4.getCustomerProjection();
        for (CustomerProjection customer : customerProjection) {
            System.out.println(customer);
        }
    }
}
