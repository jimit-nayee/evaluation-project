package com.evaluation.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.evaluation.custom_exception.ItemNotFoundException;
import com.evaluation.dto.ItemDto;

public interface ItemService {
	
	ItemDto addItem(ItemDto itemDto);
	
	Page<ItemDto> getAllPaginateItem(Pageable pageable);
	
	ItemDto getById(Long id) throws ItemNotFoundException;
	
	String deleteById(Long id);
	
	ItemDto updateItem(ItemDto itemDto) throws ItemNotFoundException;

}
