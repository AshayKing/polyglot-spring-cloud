package io.github.ashayking.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.ashayking.model.Customer;
import io.github.ashayking.model.ProductDetails;
import io.github.ashayking.service.GatewayService;

/**
 * 
 * @author Ashay S Patil
 *
 */
@RestController
@RequestMapping("/gateway")
public class GatewayController {

	@Autowired
	private GatewayService gatewayService;

	@GetMapping(value = "/product/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ProductDetails> getProductInfo(@PathVariable("id") UUID productId) {
		return new ResponseEntity<ProductDetails>(gatewayService.getProductInfo(productId), HttpStatus.OK);
	}

	@PostMapping(value = "/customer/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Customer createCustomer(@RequestBody Customer customer) {
		return gatewayService.createCustomer(customer);
	}
}