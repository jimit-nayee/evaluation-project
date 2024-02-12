package com.evaluation.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.evaluation.order.entity.Company;

public interface CompanyRepo extends MongoRepository<Company, Long> {

}
