package com.evaluation.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.evaluation.custom_exception.ItemNotFoundException;
import com.evaluation.dto.ItemDto;
import com.evaluation.entity.Item;
import com.evaluation.repository.ItemRepo;
import com.evaluation.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepo itemRepo;

	@Autowired
	private ModelMapper modelMapper;

	public static final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);

	@Override
	public ItemDto addItem(ItemDto itemDto) {
		Item item = modelMapper.map(itemDto, Item.class);
		Item savedItem = itemRepo.save(item);
		log.info("Item added successfully");
		return modelMapper.map(savedItem, ItemDto.class);
	}

	@Override
	public Page<ItemDto> getAllPaginateItem(Pageable pageable) {
		Page<Item> findAll = itemRepo.findAll(pageable);
		log.info("Got all paginated items");
		return findAll.map(item -> modelMapper.map(item, ItemDto.class));
	}

	@Override
	public ItemDto getById(Long id) throws ItemNotFoundException {
		Item item = itemRepo.findById(id)
				.orElseThrow(() -> new ItemNotFoundException("Item is not found from this item id"));
		log.info("item is found by id");
		return modelMapper.map(item, ItemDto.class);
	}

	@Override
	public String deleteById(Long id) {
		itemRepo.deleteById(id);
		log.info("item deleted successfully");
		return "Item deleted Successfully";
	}

	@Override
	public ItemDto updateItem(ItemDto itemDto) throws ItemNotFoundException {
		Item item = modelMapper.map(itemDto, Item.class);

		Item itemToUpdate = itemRepo.findById(item.getId()).orElseThrow(() -> new ItemNotFoundException("Item is not found from this item id"));

		itemToUpdate.setName(itemDto.getName());
		itemToUpdate.setCategoryId(itemDto.getCategoryId());
		itemToUpdate.setPrice(itemDto.getPrice());
		itemToUpdate.setQty(itemDto.getQty());
		itemToUpdate.setDiscount(itemDto.getDiscount());

		Item updatedItem = itemRepo.save(itemToUpdate);

		return modelMapper.map(updatedItem, ItemDto.class);
	}

}
