package io.github.ashayking.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.github.ashayking.model.Review;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

	public List<Review> findByProductId(String productId);

}