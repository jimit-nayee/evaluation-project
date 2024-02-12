package com.evaluation.order.dto;

import java.util.Date;

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
public class SellDto {

	private Long id;
	
	private Date sellDate;

	private Long customerId;

	private String billNo;
}
