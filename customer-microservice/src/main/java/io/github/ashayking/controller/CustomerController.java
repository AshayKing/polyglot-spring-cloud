package io.github.ashayking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.github.ashayking.model.Customer;
import io.github.ashayking.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Slf4j
@BaseCustomerController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<Customer> getAllCustomers() {
		log.info("Get all Customers...");
		return customerService.findAll();
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Customer createCustomer(@RequestBody Customer customer) {
		log.info("Creating Customer");
		return customerService.createCustomer(customer);
	}

	@PostMapping("/auth")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<HttpStatus> authenticateUser(@RequestBody Customer customer) {
		log.info("Authenticating Customer");
		if (customerService.authenticateUser(customer))
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		else
			return new ResponseEntity<HttpStatus>(HttpStatus.UNAUTHORIZED);
	}
}
