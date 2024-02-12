package com.evaluation.order.sevice.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.order.dto.SellItemsDto;
import com.evaluation.order.entity.SellItems;
import com.evaluation.order.repo.SellItemsRepo;
import com.evaluation.order.sevice.SellItemsService;

@Service
public class SellItemsServiceImpl implements SellItemsService{

	
	@Autowired
	private SellItemsRepo repo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public SellItemsDto saveSellingItemsData(SellItemsDto sellItemsDto) {
		SellItems map = mapper.map(sellItemsDto, SellItems.class);
		SellItems save = repo.save(map);
	
		return mapper.map(save, SellItemsDto.class);
	}

	@Override
	public List<SellItemsDto> getAllSellingItemsData() {
		List<SellItems> findAll = repo.findAll();
		return findAll.stream().map(product -> mapper.map(product, SellItemsDto.class)).toList();
	}

}
