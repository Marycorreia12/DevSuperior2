package com.devsuperior2.dsdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior2.dsdelivery.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
