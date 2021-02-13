package com.devsuperior2.dsdelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior2.dsdelivery.dto.ProductDTO;
import com.devsuperior2.dsdelivery.entities.Product;
import com.devsuperior2.dsdelivery.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	@Transactional
	public List<ProductDTO> findAll(){
		List<Product> list = repo.findAll();
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}

}
