package com.devsuperior2.dsdelivery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior2.dsdelivery.dto.OrderDTO;
import com.devsuperior2.dsdelivery.dto.ProductDTO;
import com.devsuperior2.dsdelivery.entities.Order;
import com.devsuperior2.dsdelivery.entities.Product;
import com.devsuperior2.dsdelivery.entities.enums.OrderStatus;
import com.devsuperior2.dsdelivery.repositories.OrderRepository;
import com.devsuperior2.dsdelivery.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private ProductRepository repoP;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = repo.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
		for(ProductDTO p: dto.getProducts()) {
			Product product = repoP.getOne(p.getId());
			order.getProducts().add(product);
		}
		order = repo.save(order);
		return new OrderDTO(order);
		
	}
	
	@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = repo.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = repo.save(order);
		return new OrderDTO(order);
	}
	
	


}
