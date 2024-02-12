package com.evaluation.order.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

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
@Component
@Document
public class PurchaseItems {

	@Id
	private Long id;
	private Long purchaseId;
	private Long itemId;
	private Long qty;
	private Date expiryDate;
	private Double purchasePrice;

}
