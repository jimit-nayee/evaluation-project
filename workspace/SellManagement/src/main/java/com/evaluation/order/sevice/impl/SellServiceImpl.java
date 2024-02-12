package com.evaluation.order.sevice.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.evaluation.order.dto.SellDto;
import com.evaluation.order.entity.Sell;
import com.evaluation.order.repo.SellRepo;
import com.evaluation.order.sevice.SellService;

public class SellServiceImpl implements SellService{
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private SellRepo repo;

	@Override
	public SellDto saveSellingData(SellDto sellDto) {
		Sell map = mapper.map(sellDto, Sell.class);
		Sell save = repo.save(map);
	
		return mapper.map(save, SellDto.class);
	}

	@Override
	public List<SellDto> getAllSellingData() {
		List<Sell> findAll = repo.findAll();
		return findAll.stream().map(product -> mapper.map(product, SellDto.class)).toList();
	}

}
