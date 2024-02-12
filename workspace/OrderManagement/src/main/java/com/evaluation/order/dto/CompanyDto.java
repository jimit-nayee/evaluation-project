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
public class CompanyDto {

	@Id
	private Long id;

	private String name;

	private Long mobileNo;

	private String gstNumber;

	private Double price;

}
