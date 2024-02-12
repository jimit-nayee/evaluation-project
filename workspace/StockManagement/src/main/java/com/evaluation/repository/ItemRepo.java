package com.evaluation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.evaluation.entity.Item;

public interface ItemRepo extends MongoRepository<Item, Long>{

}
