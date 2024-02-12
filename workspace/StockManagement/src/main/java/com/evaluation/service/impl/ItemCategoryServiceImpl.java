package com.evaluation.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.custom_exception.ItemCategoryNotFoundException;
import com.evaluation.dto.ItemCategoryDto;
import com.evaluation.entity.ItemCategory;
import com.evaluation.repository.ItemCategoryRepo;
import com.evaluation.service.ItemCategoryService;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

	@Autowired
	private ItemCategoryRepo itemCategoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	public static final Logger log = LoggerFactory.getLogger(ItemCategoryServiceImpl.class);

	@Override
	public ItemCategoryDto addItemCategory(ItemCategoryDto itemCategoryDto) {
		ItemCategory itemCategory = modelMapper.map(itemCategoryDto, ItemCategory.class);
		ItemCategory savedItemCategory = itemCategoryRepo.save(itemCategory);
		log.info("Item added successfully");
		return modelMapper.map(savedItemCategory, ItemCategoryDto.class);
	}

	@Override
	public List<ItemCategoryDto> getAllItemCategory() {
		List<ItemCategory> findAll = itemCategoryRepo.findAll();
		log.info("Got all paginated items");
		return findAll.stream().map(item -> modelMapper.map(item, ItemCategoryDto.class)).toList();
	}

	@Override
	public ItemCategoryDto getById(Long id) throws ItemCategoryNotFoundException {
		ItemCategory itemCategory = itemCategoryRepo.findById(id).orElseThrow(()-> new ItemCategoryNotFoundException("Item's category is not found from this id"));
		log.info("item category is found by id");
		return modelMapper.map(itemCategory, ItemCategoryDto.class);
	}
	
	@Override
	public String deleteById(Long id) {
		itemCategoryRepo.deleteById(id);
		log.info("item is deleted by id");
		return "item category is deleted successfully";
	}
	
	@Override
	public ItemCategoryDto updateItemCategory(ItemCategoryDto itemCategoryDto) throws ItemCategoryNotFoundException {
		ItemCategory itemCategory = modelMapper.map(itemCategoryDto, ItemCategory.class);

		ItemCategory itemCategoryToUpdate = itemCategoryRepo.findById(itemCategory.getId()).orElseThrow(() -> new ItemCategoryNotFoundException("Item is not found from this item id"));

		itemCategoryToUpdate.setCategoryName(itemCategoryDto.getCategoryName());
	

		ItemCategory updatedItem = itemCategoryRepo.save(itemCategoryToUpdate);

		return modelMapper.map(updatedItem, ItemCategoryDto.class);
	}



}
