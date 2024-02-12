package com.evaluation.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.evaluation.order.entity.Purchase;

public interface PurchaseRepo extends MongoRepository<Purchase, Long> {

}
