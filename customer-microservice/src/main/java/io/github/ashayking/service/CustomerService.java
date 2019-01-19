package io.github.ashayking.service;

import java.util.List;

import io.github.ashayking.model.Customer;

/**
 * 
 * @author Ashay S Patil
 *
 */
public interface CustomerService {

	List<Customer> findAll();
	
	Customer createCustomer(Customer customer);

	boolean authenticateUser(Customer customer);

}
