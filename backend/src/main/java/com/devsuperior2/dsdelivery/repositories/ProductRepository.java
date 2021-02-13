package com.devsuperior2.dsdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior2.dsdelivery.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	


}
