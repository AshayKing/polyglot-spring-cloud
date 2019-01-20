package io.github.ashayking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.ashayking.model.Review;
import io.github.ashayking.service.ReviewService;

/**
 * 
 * @author Ashay S Patil
 *
 */
@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@PostMapping(value = "/addRating")
	public ResponseEntity<Review> addNewRating(@RequestBody Review review) {
		return new ResponseEntity<Review>(reviewService.addNewRating(review), HttpStatus.OK);
	}

	@GetMapping(value = "/{productId}")
	public ResponseEntity<Review> getAverageRating(@PathVariable String productId) {
		return new ResponseEntity<Review>(reviewService.getRating(productId), HttpStatus.OK);
	}
}