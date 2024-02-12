package com.evaluation.order.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.evaluation.order.entity.Customer;

public interface CustomerRepo extends MongoRepository<Customer, Long> {

}
