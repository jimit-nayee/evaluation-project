package com.evaluation.order.sevice;

import java.util.List;

import com.evaluation.order.dto.CustomerDto;

public interface CustomerService {

	CustomerDto saveCustomerData(CustomerDto customerDto);
	
	List<CustomerDto> getAllCsutomerData();
}
