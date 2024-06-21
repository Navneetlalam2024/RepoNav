package com.example.demo.repositories;

        import org.springframework.data.repository.CrudRepository;

        import com.example.demo.entites.Customer;
/**
 * @author Navneet Lalam
 * @version 1.0
 * @since 2024-06-20
 */
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    public Customer findByCustomerId(Long customerId);
}
