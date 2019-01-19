package io.github.ashayking.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ashayking.model.Order;
import io.github.ashayking.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Ashay S Patil
 *
 */
@Slf4j
@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> createOrder(List<Order> orderList) {
		return orderList.stream().map(order -> {
			log.info("Saving : {}", order);
			order.setId(UUID.randomUUID());
			return orderRepository.save(order);
		}).collect(Collectors.toList());
	}
}
