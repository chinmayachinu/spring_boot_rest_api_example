package com.example.cca.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cca.model.Customer;
import com.example.cca.service.CustomerService;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {
	@Autowired
	private CustomerService service;

	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@PostMapping("/customer")
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		return ResponseEntity.ok(service.save(customer));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Long id) {
		Optional<Customer> customer = service.findById(id);

		return ResponseEntity.ok(customer.get());
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer) {
		 Optional<Customer> customerData = service.findById(id);

	        if (customerData.isPresent()) {
	        	Customer _customer = customerData.get();
	        	_customer.setCustomerName(customer.getCustomerName());
	        	_customer.setCompanyName(customer.getCompanyName());
	        	_customer.setCustomerDatabaseId(customer.getCustomerDatabaseId());
	        	_customer.setDistrictId(customer.getDistrictId());
	        	_customer.setCreateDate(customer.getCreateDate());
	        	_customer.setTransactionDate(customer.getTransactionDate());

	          return new ResponseEntity<>(service.save(_customer), HttpStatus.OK);
	        } else {
	          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@DeleteMapping("/customers")
	public ResponseEntity<HttpStatus> deleteAllCustomers() {
		try {
			service.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}
}
