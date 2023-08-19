package lk.ijse.gdse.orm.hibernate.repository;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import lk.ijse.gdse.orm.hibernate.entity.Order;
import lk.ijse.gdse.orm.hibernate.projection.CustomerProjection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerRepository {

    private Session session;

    public CustomerRepository() {}

    public void setSession(Session session) {
        this.session = session;
    }

    public int saveCustomer(Customer customer) {
        return (int) session.save(customer);
    }

    public Customer getCustomer(int id) {
        return session.get(Customer.class, id);
    }

    public void updateCustomer(Customer customer) {
            session.update(customer);
    }

    public void deleteCustomer(Customer customer) {
            session.delete(customer);
    }

//    public List<Customer> getAllCustomerNative() {
//        String sql = "SELECT * FROM customer";
//        Query query = session.createSQLQuery(sql);
//        List list = query.list();
//        session.close();
//        System.out.println(list.get(1));
//        return list;
//    }


    // JPQL Get ALL
    public List<Customer> getAllCustomerJPQL() {
        String sql = "SELECT C FROM Customer AS C";
        Query query = session.createQuery(sql);
        List list = query.list();
        session.close();
        return list;
    }

    // JPQL Where
    public Customer getCustomerById(int id) {
        String sql = "SELECT C FROM Customer AS C WHERE C.id = :cus_id";
        Query namedQuery = session.createQuery(sql);
        namedQuery.setParameter("cus_id", id);
        Customer customer = (Customer) namedQuery.getSingleResult();
        session.close();
        return customer;
    }

    public List<Order> getOrdersByCustomerId(int id) {
        String sql = "SELECT O FROM Order AS O\n" +
                "INNER JOIN Customer AS C\n" +
                "ON O.customer.id = C.id\n" +
                "WHERE O.customer.id = :cus_id";
        Query query = session.createQuery(sql);
        query.setParameter("cus_id", id);
        List list = query.list();
        session.close();
        return list;
    }

    // HQL
    public List<Customer> getCustomersHQL() {
        String sql = "FROM Customer";
        Query query = session.createQuery(sql);
        List list = query.list();
        session.close();
        return list;
    }

    public List<CustomerProjection> getCustomerProjection() {
        String sql = "SELECT new lk.ijse.gdse.orm.hibernate.projection.CustomerProjection(" +
                "C.id, C.name, C.address) FROM Customer AS C";
        Query query = session.createQuery(sql);
        List list = query.list();
        session.close();
        return list;
    }
}
