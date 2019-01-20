package io.github.ashayking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.ashayking.model.Product;
import io.github.ashayking.service.ProductService;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/{productId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Product> getProductInfo(@PathVariable("productId") String productId) {
		log.info("Inside : getProductInfo");
		return new ResponseEntity<Product>(productService.getProductInfo(productId), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Product>> listAllProducts() {
		log.info("Inside : listAllProducts");
		return new ResponseEntity<List<Product>>(productService.listAll(), HttpStatus.OK);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Product> createtProductInfo() {
		log.info("Inside : createtProductInfo");
		if (productService.addProducts())
			return new ResponseEntity<Product>(HttpStatus.OK);
		return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
