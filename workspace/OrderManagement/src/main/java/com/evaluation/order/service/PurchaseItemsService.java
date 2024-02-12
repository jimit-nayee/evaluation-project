package com.evaluation.order.service;

import java.util.List;

import com.evaluation.order.dto.PurchaseItemsDto;

public interface PurchaseItemsService {
	
	PurchaseItemsDto savePurchaseItems(PurchaseItemsDto purchaseItemsDto);
	
	List<PurchaseItemsDto> getAllPurchasedItems();
	

}
