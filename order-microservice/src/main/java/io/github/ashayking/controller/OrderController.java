package io.github.ashayking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.ashayking.model.Order;
import io.github.ashayking.service.OrderService;

/**
 * 
 * @author Ashay S Patil
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/create")
	public ResponseEntity<List<Order>> createOrder(@RequestBody ArrayList<Order> orderList) {
		return new ResponseEntity<List<Order>>(orderService.createOrder(orderList), HttpStatus.OK);
	}
}