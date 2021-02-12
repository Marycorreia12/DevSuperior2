package com.devsuperior2.dsdelivery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior2.dsdelivery.entities.Order;
import com.devsuperior2.dsdelivery.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	public List<Order> findAll(){
		return repo.findAll();
	}
	
	public Order insert(Order order) {
		return repo.save(order);
		
	}


}
