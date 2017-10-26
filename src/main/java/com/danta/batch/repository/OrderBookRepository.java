package com.danta.batch.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.danta.batch.model.OrderBook;

public interface OrderBookRepository extends MongoRepository<OrderBook, Long>{
	

}
