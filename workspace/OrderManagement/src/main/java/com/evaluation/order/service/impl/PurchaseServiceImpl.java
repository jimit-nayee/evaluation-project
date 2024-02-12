package com.evaluation.order.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.order.dto.PurchaseDto;
import com.evaluation.order.entity.Purchase;
import com.evaluation.order.repository.PurchaseRepo;
import com.evaluation.order.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PurchaseRepo purchaseRepo;
	
	@Override
	public PurchaseDto savePurchaseDetails(PurchaseDto purchaseDto) {
		Purchase purchase = modelMapper.map(purchaseDto, Purchase.class);
		Purchase savedPurchase = purchaseRepo.save(purchase);
		return modelMapper.map(savedPurchase, PurchaseDto.class);
	}

	@Override
	public List<PurchaseDto> getAllPurchaseDetails() {
		List<Purchase> findAll = purchaseRepo.findAll();
		return findAll.stream().map(purchase -> modelMapper.map(purchase, PurchaseDto.class)).toList();
	}

}
