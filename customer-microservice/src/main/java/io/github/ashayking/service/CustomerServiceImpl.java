package io.github.ashayking.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.github.ashayking.exception.ServiceException;
import io.github.ashayking.model.Customer;
import io.github.ashayking.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		customer.setCustomerId(UUID.randomUUID());
		customer.setCreateDate(new Date());
		if (!isValidCreateUserRequest(customer)) {
			throw new ServiceException("Invalid create user request.");
		}
		return customerRepository.save(customer);
	}

	private boolean isValidCreateUserRequest(Customer customer) {
		boolean isValid = false;
		if (customer != null && !StringUtils.isEmpty(customer.getCustomerId())
				&& !StringUtils.isEmpty(customer.getPassword())) {
			isValid = true;
		}
		log.info("isValidCreateUserRequest: " + isValid);

		return isValid;
	}

	@Override
	public boolean authenticateUser(Customer customer) {
		// Required Fields
		if (customer == null || StringUtils.isEmpty(customer.getEmail())
				|| StringUtils.isEmpty(customer.getPassword()))
			return false;

		// Fetch Customer Obj from DB
		Customer customerOpt = customerRepository.findByEmail(customer.getEmail());

		// Compare Password
		return customerOpt.getPassword().equals(customer.getPassword());
	}

}
