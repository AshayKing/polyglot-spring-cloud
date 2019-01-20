package io.github.ashayking.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.ashayking.model.Customer;
import io.github.ashayking.model.Inventory;
import io.github.ashayking.model.Product;
import io.github.ashayking.model.ProductDetails;
import io.github.ashayking.model.Review;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Slf4j
@Service
public class GatewayService {

	@Value("${product.service.uri}")
	private String productServiceUri;

	@Value("${customer.service.uri}")
	private String customerServiceUri;

	@Value("${review.service.uri}")
	private String reviewServiceUri;

	@Value("${inventory.service.uri}")
	private String inventoryServiceUri;

	@Autowired
	private RestTemplate restTemplate;

	public ProductDetails getProductInfo(UUID productId) {
		log.info("Inside : getProductInfo");

		Product product = restTemplate.getForObject(productServiceUri + productId, Product.class);
		log.info("Fetched Product");

		Review review = restTemplate.getForObject(reviewServiceUri + productId, Review.class);
		log.info("Fetched Review");

		Inventory inventory = restTemplate.getForObject(inventoryServiceUri + productId, Inventory.class);
		log.info("Fetched Inventory");

		ProductDetails details = new ProductDetails(product, review == null ? 0d : review.getRating(),
				inventory == null ? 0 : inventory.getAvailableStock());
		return details;
	}

	public Customer createCustomer(Customer customer) {
		log.info("Create Customer");
		Customer createdCustomer = restTemplate.postForObject(customerServiceUri + "create", customer, Customer.class);
		return createdCustomer;
	}
}