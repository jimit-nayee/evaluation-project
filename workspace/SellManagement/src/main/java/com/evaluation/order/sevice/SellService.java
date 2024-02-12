package com.evaluation.order.sevice;

import java.util.List;

import com.evaluation.order.dto.SellDto;

public interface SellService {

	SellDto saveSellingData(SellDto sellDto);
	
	List<SellDto> getAllSellingData();
}
