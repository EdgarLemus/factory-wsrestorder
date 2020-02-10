package com.sophos.poc.orden.repository;


import org.springframework.data.repository.CrudRepository;

import com.sophos.poc.orden.model.Orders;

public interface OrdersRepository extends CrudRepository<Orders, String>{
	
}
