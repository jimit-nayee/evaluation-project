package com.evaluation.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.evaluation.custom_exception.ItemCategoryNotFoundException;
import com.evaluation.custom_exception.ItemNotFoundException;

@RestControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<String> itemNotFoundException(ItemNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ItemCategoryNotFoundException.class)
	public ResponseEntity<String> itemNotFoundException(ItemCategoryNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
