package com.evaluation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.evaluation.entity.ItemCategory;

public interface ItemCategoryRepo extends MongoRepository<ItemCategory, Long>{

}
