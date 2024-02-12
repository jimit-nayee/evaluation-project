package com.evaluation.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.evaluation.order.entity.PurchaseItems;

public interface PurchaseItemsRepo extends MongoRepository<PurchaseItems, Long> {

}
