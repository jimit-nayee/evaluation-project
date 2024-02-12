package com.evaluation.order.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.evaluation.order.entity.SellItems;

public interface SellItemsRepo extends MongoRepository<SellItems, Long> {

}
