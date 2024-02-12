package com.evaluation.order.sevice;

import java.util.List;

import com.evaluation.order.dto.CustomerDto;
import com.evaluation.order.dto.SellItemsDto;

public interface SellItemsService {

	SellItemsDto saveSellingItemsData(SellItemsDto sellItemsDto);
	
	List<SellItemsDto> getAllSellingItemsData();
}
