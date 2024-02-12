package com.evaluation.service;

import java.util.List;

import com.evaluation.custom_exception.ItemCategoryNotFoundException;
import com.evaluation.dto.ItemCategoryDto;

public interface ItemCategoryService {
	
	ItemCategoryDto addItemCategory(ItemCategoryDto itemCategoryDto);
	
	List<ItemCategoryDto> getAllItemCategory();
	
	ItemCategoryDto getById(Long id) throws ItemCategoryNotFoundException;
	
	String deleteById(Long id);
	
	ItemCategoryDto updateItemCategory(ItemCategoryDto itemCategoryDto) throws ItemCategoryNotFoundException;

}
