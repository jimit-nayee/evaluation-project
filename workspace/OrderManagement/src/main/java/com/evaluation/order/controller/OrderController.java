package com.evaluation.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.order.dto.CompanyDto;
import com.evaluation.order.dto.PurchaseDto;
import com.evaluation.order.dto.PurchaseItemsDto;
import com.evaluation.order.service.CompanyService;
import com.evaluation.order.service.PurchaseItemsService;
import com.evaluation.order.service.PurchaseService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/makeOrderToCompany")
	public ResponseEntity<CompanyDto> makeOrderToCompany(@Valid @RequestBody CompanyDto companyDto){
		return new ResponseEntity<>(companyService.makeOrderToCompany(companyDto),HttpStatus.OK);
	}
	
	@GetMapping("/getAllGivenOrder")
	public ResponseEntity<List<CompanyDto>> getAllGivenOrder() {
		return new ResponseEntity<>(companyService.getAllGivenOrder(), HttpStatus.OK);
	}
	
	
	
	@Autowired
	private PurchaseService purchaseService;
	
	@PostMapping("/savePurchaseDetails")
	public ResponseEntity<PurchaseDto> savePurchaseDetails(@Valid @RequestBody PurchaseDto purchaseDto){
		return new ResponseEntity<>(purchaseService.savePurchaseDetails(purchaseDto),HttpStatus.OK);
	}
	
	@GetMapping("/getAllPurchaseDetails")
	public ResponseEntity<List<PurchaseDto>> getAllPurchaseDetails() {
		return new ResponseEntity<>(purchaseService.getAllPurchaseDetails(), HttpStatus.OK);
	}
	
	@Autowired
	private PurchaseItemsService purchaseItemsService;
	@PostMapping("/savePurchaseItems")
	public ResponseEntity<PurchaseItemsDto> savePurchaseItems(@Valid @RequestBody PurchaseItemsDto purchaseItemsDto){
		return new ResponseEntity<>(purchaseItemsService.savePurchaseItems(purchaseItemsDto),HttpStatus.OK);
	}
	
	@GetMapping("/getAllPurchasedItems")
	public ResponseEntity<List<PurchaseItemsDto>> getAllPurchasedItems() {
		return new ResponseEntity<>(purchaseItemsService.getAllPurchasedItems(), HttpStatus.OK);
	}
}
