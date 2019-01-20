package io.github.ashayking.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.github.ashayking.model.Inventory;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Repository
public interface InventoryRepository extends MongoRepository<Inventory, UUID> {

	public Inventory findByProductId(UUID productId);

}