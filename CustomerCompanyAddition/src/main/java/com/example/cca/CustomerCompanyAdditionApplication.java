package com.example.cca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cca.model.Customer;
import com.example.cca.repository.CustomerRepository;

@SpringBootApplication
public class CustomerCompanyAdditionApplication implements CommandLineRunner {
	@Autowired
	CustomerRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(CustomerCompanyAdditionApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Customer("Chinmaya","Infinite", 180507,1,758023, "05-08-2020", "05-08-2020"));
	}
}
