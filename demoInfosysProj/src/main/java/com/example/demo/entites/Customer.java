package com.example.demo.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Navneet Lalam
 * @version 1.0
 * @since 2024-06-20
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    @NotBlank(message="CustomerId can not be blanked !")
    private Long customerId;
    @Column(name = "CUSTOMER_NAME")
    @NotBlank(message="customerName can not be blanked !")
    @Size(min = 2, max = 50)
    private String customerName;

}
