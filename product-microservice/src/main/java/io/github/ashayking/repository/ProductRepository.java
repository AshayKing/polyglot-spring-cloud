package io.github.ashayking.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.github.ashayking.model.Product;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, UUID> {

	List<Product> findAll();

}
