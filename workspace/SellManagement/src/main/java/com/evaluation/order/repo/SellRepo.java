package com.evaluation.order.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.evaluation.order.entity.Sell;

public interface SellRepo extends MongoRepository<Sell, Long> {

}
