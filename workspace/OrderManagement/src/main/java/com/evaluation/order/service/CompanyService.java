package com.evaluation.order.service;

import java.util.List;

import com.evaluation.order.dto.CompanyDto;

public interface CompanyService {

	CompanyDto makeOrderToCompany(CompanyDto companyDto);
	
	List<CompanyDto> getAllGivenOrder();

}
