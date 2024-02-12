package com.evaluation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.custom_exception.ItemCategoryNotFoundException;
import com.evaluation.custom_exception.ItemNotFoundException;
import com.evaluation.dto.ItemCategoryDto;
import com.evaluation.dto.ItemDto;
import com.evaluation.service.ItemCategoryService;
import com.evaluation.service.ItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@PostMapping("/addItem")
	public ResponseEntity<ItemDto> addItem(@Valid @RequestBody ItemDto itemDto){
		return new ResponseEntity<>(itemService.addItem(itemDto),HttpStatus.OK);
	}
	
	@GetMapping("/getAllItem")
	public ResponseEntity<Page<ItemDto>> getAllItem(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "ASC") Sort.Direction sortDirection) {

		Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
		return new ResponseEntity<>(itemService.getAllPaginateItem(pageable), HttpStatus.OK);
	}
	
	@GetMapping("/getItemById/{id}")
	public ResponseEntity<ItemDto> getItemById(@Valid @PathVariable Long id) throws ItemNotFoundException {
		return new ResponseEntity<>(itemService.getById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteItemById/{id}")
	public ResponseEntity<String> deleteItemById(@Valid @PathVariable Long id) {
		return new ResponseEntity<>(itemService.deleteById(id), HttpStatus.OK);
	}

	@PutMapping("/updateItemById")
	public ResponseEntity<ItemDto> updateItemById(@Valid @RequestBody ItemDto userDto) throws ItemNotFoundException {
		return new ResponseEntity<>(itemService.updateItem(userDto), HttpStatus.OK);
	}
	
	
	
	
	@Autowired
	private ItemCategoryService itemCategoryService;
	
	@PostMapping("/addItemCategory")
	public ResponseEntity<ItemCategoryDto> addItemCategory(@Valid @RequestBody ItemCategoryDto itemCategoryDto){
		return new ResponseEntity<>(itemCategoryService.addItemCategory(itemCategoryDto),HttpStatus.OK);
	}
	
	@GetMapping("/getAllItemCategory")
	public ResponseEntity<List<ItemCategoryDto>> getAllItemCategory() {
		return new ResponseEntity<>(itemCategoryService.getAllItemCategory(), HttpStatus.OK);
	}
	
	@GetMapping("/getItemCategoryById/{id}")
	public ResponseEntity<ItemCategoryDto> getItemCategoryById(@Valid @PathVariable Long id) throws ItemCategoryNotFoundException {
		return new ResponseEntity<>(itemCategoryService.getById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCategoryById/{id}")
	public ResponseEntity<String> deleteCategoryById(@Valid @PathVariable Long id) {
		return new ResponseEntity<>(itemCategoryService.deleteById(id), HttpStatus.OK);
	}

	@PutMapping("/updateCategoryById")
	public ResponseEntity<ItemCategoryDto> updateCategoryById(@Valid @RequestBody ItemCategoryDto userDto) throws ItemCategoryNotFoundException {
		return new ResponseEntity<>(itemCategoryService.updateItemCategory(userDto), HttpStatus.OK);
	}
}