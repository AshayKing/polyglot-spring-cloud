package io.github.ashayking.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ashayking.model.Inventory;
import io.github.ashayking.repository.InventoryRepository;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Service
public class InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	public Inventory getInventory(UUID productId) {
		return inventoryRepository.findByProductId(productId);
	}

	public Inventory createInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	public void deleteAllInventory() {
		inventoryRepository.deleteAll();
	}

}