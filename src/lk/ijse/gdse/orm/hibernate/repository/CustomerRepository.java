package lk.ijse.gdse.orm.hibernate.repository;

import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    void setSession(Session session);
}
