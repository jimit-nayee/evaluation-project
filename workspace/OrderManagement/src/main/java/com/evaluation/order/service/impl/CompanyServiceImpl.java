package com.evaluation.order.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.order.dto.CompanyDto;
import com.evaluation.order.entity.Company;
import com.evaluation.order.repository.CompanyRepo;
import com.evaluation.order.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepo companyRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CompanyDto makeOrderToCompany(CompanyDto companyDto) {

		Company company = modelMapper.map(companyDto, Company.class);

		Company savedCompany = companyRepo.save(company);

		return modelMapper.map(savedCompany, CompanyDto.class);
	}

	@Override
	public List<CompanyDto> getAllGivenOrder() {

		List<Company> findAllCompany = companyRepo.findAll();
		return findAllCompany.stream().map(order -> modelMapper.map(order, CompanyDto.class)).toList();
	}
}
