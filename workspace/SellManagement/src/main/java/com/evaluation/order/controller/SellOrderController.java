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

import com.evaluation.order.dto.CustomerDto;
import com.evaluation.order.dto.SellDto;
import com.evaluation.order.dto.SellItemsDto;
import com.evaluation.order.sevice.CustomerService;
import com.evaluation.order.sevice.SellItemsService;
import com.evaluation.order.sevice.SellService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sell")
public class SellOrderController{
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/saveCustomerData")
	public ResponseEntity<CustomerDto> saveCustomerData(@Valid @RequestBody CustomerDto customerDto){
		return new ResponseEntity<>(customerService.saveCustomerData(customerDto),HttpStatus.OK);
	}
	
	@GetMapping("/getAllCsutomerData")
	public ResponseEntity<List<CustomerDto>> getAllCsutomerData() {
		return new ResponseEntity<>(customerService.getAllCsutomerData(), HttpStatus.OK);
	}
	
	
	@Autowired
	private SellService sellService;
	
	
	@PostMapping("/saveSellingData")
	public ResponseEntity<SellDto> saveSellingData(@Valid @RequestBody SellDto sellDto){
		return new ResponseEntity<>(sellService.saveSellingData(sellDto),HttpStatus.OK);
	}
	
	@GetMapping("/getAllSellingData")
	public ResponseEntity<List<SellDto>> getAllSellingData() {
		return new ResponseEntity<>(sellService.getAllSellingData(), HttpStatus.OK);
	}
	
	
	@Autowired
	private SellItemsService sellItemsService;
	
	@PostMapping("/saveSellingItemsData")
	public ResponseEntity<SellItemsDto> saveSellingItemsData(@Valid @RequestBody SellItemsDto sellItemsDto){
		return new ResponseEntity<>(sellItemsService.saveSellingItemsData(sellItemsDto),HttpStatus.OK);
	}
	
	@GetMapping("/getAllSellingItemsData")
	public ResponseEntity<List<SellItemsDto>> getAllSellingItemsData() {
		return new ResponseEntity<>(sellItemsService.getAllSellingItemsData(), HttpStatus.OK);
	}
	
}
