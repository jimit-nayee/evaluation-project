package com.evaluation.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class Item {

	@Id
	private Long id;
	
	@NotEmpty
	private String name;

	@NotNull
	private Long categoryId;

	@NotNull
	private Double price;

	@NotNull
	private Long qty;

	@NotNull
	private Double discount;

}
