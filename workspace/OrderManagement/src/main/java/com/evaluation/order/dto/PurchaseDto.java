package com.evaluation.order.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PurchaseDto {
	
	@Id
	private Long id;
	
	private Date purchaseDate;
	
	private Long companyId;
	
	private String billNumber;
}
