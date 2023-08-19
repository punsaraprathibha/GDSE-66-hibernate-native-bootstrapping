package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

public class DetachedState {

    public static void main(String[] args) {


        Session session = SessionFactoryConfig.getInstance()
                .getSession();

        // Transient State
        Customer customer = new Customer();
        customer.setName("Saman");
        customer.setAddress("Galle");
        customer.setSalary(25000.00);
        customer.setAge(20);

//        System.out.println(
//                isExistsInSession(session, customer));

        // Persistent State
        int cusId = (int) session.save(customer);

        System.out.println(
                isExistsInSession(session, customer));

        session.close();


        Session session1 = SessionFactoryConfig
                .getInstance().getSession();

        session1.detach(customer);

        System.out.println(
                isExistsInSession(session1, customer));

        customer.setAddress("Matara");
        session1.save(customer);

        System.out.println(session1.contains(customer));

        session1.close();
    }

    private static String isExistsInSession(Session session, Customer customer) {
        return session.contains(customer)
                ? "This Object is in Persistent State"
                : "This object is in Detached State";
    }
}
