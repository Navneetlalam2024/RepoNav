package com.example.demo.repositories;

import java.sql.Timestamp;
import java.util.List;

import com.example.demo.entites.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Navneet Lalam
 * @version 1.0
 * @since 2024-06-20
 */
@Repository
@Transactional
public interface TransactionRepository extends CrudRepository<Transaction,Long> {
   // public List<Transaction> findAllByCustomerId(Long customerId);

    public List<Transaction> findAllByCustomerIdAndTransactionDateBetween(Long customerId, Timestamp from,Timestamp to);
}
