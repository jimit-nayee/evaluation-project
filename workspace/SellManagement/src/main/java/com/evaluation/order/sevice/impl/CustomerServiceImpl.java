package com.evaluation.order.sevice.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.order.dto.CustomerDto;
import com.evaluation.order.entity.Customer;
import com.evaluation.order.repo.CustomerRepo;
import com.evaluation.order.sevice.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public CustomerDto saveCustomerData(CustomerDto customerDto) {
		Customer map = mapper.map(customerDto, Customer.class);
		Customer save = customerRepo.save(map);
	
		return mapper.map(save, CustomerDto.class);
	}

	@Override
	public List<CustomerDto> getAllCsutomerData() {
		List<Customer> findAll = customerRepo.findAll();
		return findAll.stream().map(product -> mapper.map(product, CustomerDto.class)).toList();
	}

}
