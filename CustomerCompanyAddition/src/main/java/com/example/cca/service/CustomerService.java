package com.example.cca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cca.model.Customer;
import com.example.cca.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repository;

	public List<Customer> findAll() {
		return repository.findAll();
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

	public Customer save(Customer Customer) {
		return repository.save(Customer);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

}
