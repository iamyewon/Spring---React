package com.example.customer.repository;

import com.example.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

// JPARepository 상속
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
