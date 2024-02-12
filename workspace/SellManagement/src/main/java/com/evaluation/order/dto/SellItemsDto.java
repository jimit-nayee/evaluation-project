package com.evaluation.order.dto;

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
public class SellItemsDto {


	@Id
	private Long id;
	private Long sellId;
	private Long itemId;
	private Long qty;
	private Double sellPrice;

}
