package io.github.ashayking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ashayking.model.Review;
import io.github.ashayking.repository.ReviewRepository;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	public Review addNewRating(Review review) {
		return reviewRepository.save(review);
	}

	public Review getRating(String productId) {
		List<Review> reviewsForProduct = reviewRepository.findByProductId(productId);
		double overallSum = reviewsForProduct.stream().mapToDouble(Review::getRating).sum();
		double rating = overallSum / (reviewsForProduct.size());
		Review review = new Review();
		review.setProductId(productId);
		review.setRating(rating);
		return review;
	}
}