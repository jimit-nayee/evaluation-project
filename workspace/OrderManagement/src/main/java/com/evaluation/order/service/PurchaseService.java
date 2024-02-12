package com.evaluation.order.service;

import java.util.List;

import com.evaluation.order.dto.PurchaseDto;

public interface PurchaseService {
	
	PurchaseDto savePurchaseDetails(PurchaseDto purchaseDto);
	
	List<PurchaseDto> getAllPurchaseDetails();

}
