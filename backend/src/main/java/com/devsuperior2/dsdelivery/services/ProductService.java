package com.devsuperior2.dsdelivery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior2.dsdelivery.entities.Product;
import com.devsuperior2.dsdelivery.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	public List<Product> findAll(){
		return repo.findAll();
	}

}
