package io.github.ashayking.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.github.ashayking.model.Order;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Repository
public interface OrderRepository extends MongoRepository<Order, UUID> {

}
