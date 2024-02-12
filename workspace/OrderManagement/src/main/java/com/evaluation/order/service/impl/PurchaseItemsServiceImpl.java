package com.evaluation.order.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.order.dto.PurchaseItemsDto;
import com.evaluation.order.entity.PurchaseItems;
import com.evaluation.order.repository.PurchaseItemsRepo;
import com.evaluation.order.service.PurchaseItemsService;

@Service
public class PurchaseItemsServiceImpl implements PurchaseItemsService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PurchaseItemsRepo purchaseItemsRepo;

	@Override
	public PurchaseItemsDto savePurchaseItems(PurchaseItemsDto purchaseItemsDto) {
		PurchaseItems purchaseItems = modelMapper.map(purchaseItemsDto, PurchaseItems.class);
		PurchaseItems savedPurchaseItems = purchaseItemsRepo.save(purchaseItems);
		return modelMapper.map(savedPurchaseItems, PurchaseItemsDto.class);
	}

	@Override
	public List<PurchaseItemsDto> getAllPurchasedItems() {
		List<PurchaseItems> findAll = purchaseItemsRepo.findAll();
		return findAll.stream().map(purchase -> modelMapper.map(purchase,PurchaseItemsDto.class)).toList();
	}

}
