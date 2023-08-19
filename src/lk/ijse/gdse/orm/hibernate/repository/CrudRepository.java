package lk.ijse.gdse.orm.hibernate.repository;

public interface CrudRepository<T, ID> {

    ID saveCustomer(T customer);

    T getCustomer(ID id);

    void updateCustomer(T customer);

    void deleteCustomer(T customer);
}
