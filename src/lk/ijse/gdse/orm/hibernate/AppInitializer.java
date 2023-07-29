package lk.ijse.gdse.orm.hibernate;


import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * This is the Main class of this Hibernate Application
 * So, let's call it as "AppInitializer"
 */
public class AppInitializer {

    /**
     * @param args : java.lang.String[]
     * Main method of this Application
     */
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Kamal");
        customer.setAddress("Galle");
        customer.setSalary(25000.00);

        // 1. Save
        Session saveSession = SessionFactoryConfig
                .getInstance()
                .getSession();
        Transaction saveTransaction = saveSession.beginTransaction();
        saveSession.save(customer); // Persists (Saves) customer object in DB
        saveTransaction.commit();
        saveSession.close();

        // 2. Update
        Session updateSession = SessionFactoryConfig
                .getInstance()
                .getSession();
        Transaction updateTransaction = updateSession.beginTransaction();

        // 3. Get
        Customer customer1 = updateSession.get(Customer.class, 1); // Retrieves (Get) customer data from DB by ID
        customer1.setAddress("Hambantota");
        customer1.setName("Amara");
//        updateSession.save(customer1); // You can use this to update an already existing data in DB
        updateSession.update(customer1); // Or you can use this to update an already existing data in DB

        updateTransaction.commit();
        updateSession.close();

        // 4. Delete
        Session deleteSession = SessionFactoryConfig
                .getInstance()
                .getSession();
        Transaction deleteTransaction = deleteSession.beginTransaction();
        Customer deleteCustomer = deleteSession.get(Customer.class, 1);
        deleteSession.delete(deleteCustomer); // Deletes a Customer from DB
        deleteTransaction.commit();
        deleteSession.close();
    }
}
