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
public class PurchaseItemsDto {

	@Id
	private Long id;
	private Long purchaseId;
	private Long itemId;
	private Long qty;
	private Date expiryDate;
	private Double purchasePrice;

}
