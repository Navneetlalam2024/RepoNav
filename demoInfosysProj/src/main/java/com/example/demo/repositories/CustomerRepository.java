package com.example.demo.repositories;

        import org.springframework.data.repository.CrudRepository;

        import com.example.demo.entites.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    public Customer findByCustomerId(Long customerId);
}
