package lk.ijse.gdse.orm.hibernate;


import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.embedded.MobileNo;
import lk.ijse.gdse.orm.hibernate.embedded.NameIdentifier;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import lk.ijse.gdse.orm.hibernate.repository.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

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
        Customer customer = getCustomer();

        CustomerRepository cusRepository = new CustomerRepository();
        int savedCusId = cusRepository.saveCustomer(customer);
        System.out.println("Saved Cus Id: "
                + savedCusId);

        cusRepository = new CustomerRepository();
        Customer existingCustomer = cusRepository.getCustomer(savedCusId);
        System.out.println(existingCustomer);

        cusRepository = new CustomerRepository();
        existingCustomer.setAddress("Matara");
        boolean isUpdated = cusRepository.updateCustomer(existingCustomer);
        if (isUpdated) {
            System.out.println("Customer Updated!");
        } else {
            System.out.println("Customer Update Failed!");
        }

        cusRepository = new CustomerRepository();
        boolean isDeleted = cusRepository.deleteCustomer(existingCustomer);
        if (isDeleted) {
            System.out.println("Customer Deleted!");
        } else {
            System.out.println("Customer Deletion Failed!");
        }


//        // 1. Save
//        Session saveSession = SessionFactoryConfig
//                .getInstance()
//                .getSession();
//        Transaction saveTransaction = saveSession.beginTransaction();
//        saveSession.save(customer); // Persists (Saves) customer object in DB
//        saveTransaction.commit();
//        saveSession.close();
//
//        // 2. Update
//        Session updateSession = SessionFactoryConfig
//                .getInstance()
//                .getSession();
//        Transaction updateTransaction = updateSession.beginTransaction();
//
//        // 3. Get
//        Customer customer1 = updateSession.get(Customer.class, 1); // Retrieves (Get) customer data from DB by ID
//        customer1.setAddress("Hambantota");
//        customer1.setName("Amara");
////        updateSession.save(customer1); // You can use this to update an already existing data in DB
//        updateSession.update(customer1); // Or you can use this to update an already existing data in DB
//
//        updateTransaction.commit();
//        updateSession.close();
//
//        // 4. Delete
//        Session deleteSession = SessionFactoryConfig
//                .getInstance()
//                .getSession();
//        Transaction deleteTransaction = deleteSession.beginTransaction();
//        Customer deleteCustomer = deleteSession.get(Customer.class, 1);
//        deleteSession.delete(deleteCustomer); // Deletes a Customer from DB
//        deleteTransaction.commit();
//        deleteSession.close();
    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        NameIdentifier nameIdentifier = getNameIdentifier();
        customer.setNameIdentifier(nameIdentifier);
        customer.setAddress("Galle");
        customer.setSalary(25000.00);

        List<MobileNo> mobileNos = getMobileNos();
        customer.setPhoneNos(mobileNos);
        return customer;
    }

    private static List<MobileNo> getMobileNos() {
        List<MobileNo> mobileNos = new ArrayList<>();
        MobileNo homeNo = new MobileNo();
        homeNo.setType("HOME");
        homeNo.setMobileNo("0913456767");
        mobileNos.add(homeNo);

        MobileNo mobileNo = new MobileNo();
        mobileNo.setType("MOBILE");
        mobileNo.setMobileNo("0713456767");
        mobileNos.add(mobileNo);
        return mobileNos;
    }

    private static NameIdentifier getNameIdentifier() {
        NameIdentifier nameIdentifier = new NameIdentifier();
        nameIdentifier.setFirstName("Saman");
        nameIdentifier.setMiddleName("Perera");
        nameIdentifier.setLastName("De Silva");
        return nameIdentifier;
    }
}
