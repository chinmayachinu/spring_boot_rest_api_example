package com.example.cca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cca.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
