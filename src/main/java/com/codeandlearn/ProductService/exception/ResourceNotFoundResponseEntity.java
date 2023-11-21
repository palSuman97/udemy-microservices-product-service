package com.codeandlearn.ProductService.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceNotFoundResponseEntity {

	private HttpStatus httpStatus;
	private String msg;
	private String errorCode;
}
