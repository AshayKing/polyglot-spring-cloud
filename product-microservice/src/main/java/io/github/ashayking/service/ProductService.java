package io.github.ashayking.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ashayking.model.Product;
import io.github.ashayking.repository.ProductRepository;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public boolean addProduct(Product product) {
		productRepository.save(product);
		return true;
	}

	public boolean isValid(UUID productId) {
		if (!(productRepository.existsById(productId)))
			return false;
		return true;
	}

	public List<Product> listAll() {
		if (addProducts())
			return productRepository.findAll();
		return null;
	}

	public boolean addProducts() {
		productRepository.deleteAll();

		Stream<Product> productListStream = Stream.of(new Product(UUID.randomUUID(), "SonyTV", 259.23, "Electronics"),
				new Product(UUID.randomUUID(), "ZenDesk Keyboard", 40.00, "Electronics"),
				new Product(UUID.randomUUID(), "VeraModa Top", 20.00, "Clothing"),
				new Product(UUID.randomUUID(), "Jeans", 25.00, "Clothing"),
				new Product(UUID.randomUUID(), "Sweater Top", 25.00, "Clothing"),
				new Product(UUID.randomUUID(), "Jeans", 25.00, "Clothing"),
				new Product(UUID.randomUUID(), "Logitech Monitor", 40.00, "Electronics"));

		productListStream.forEach(productRepository::save);
		return true;
	}
}
