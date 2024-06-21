package com.example.demo.entites;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author Navneet Lalam
 * @version 1.0
 * @since 2024-06-20
 */
@Entity
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    @NotBlank(message="transactionId can not be blanked !")
    private Long transactionId;

    @Column(name = "CUSTOMER_ID")
    @NotBlank(message="customerId can not be blanked !")
    private Long customerId;

    @Column(name = "TRANSACTION_DATE")
    @NotBlank(message="transactionDate can not be blanked !")
    private Timestamp transactionDate;

    @Column(name = "AMOUNT")
    private double transactionAmount;


    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
