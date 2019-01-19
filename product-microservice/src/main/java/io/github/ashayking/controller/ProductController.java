package io.github.ashayking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.ashayking.model.Product;
import io.github.ashayking.service.ProductService;

/**
 * 
 * @author Ashay S Patil
 *
 */
@RestController("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> listAllProducts() {
		return new ResponseEntity<List<Product>>(productService.listAll(), HttpStatus.OK);
	}

}
