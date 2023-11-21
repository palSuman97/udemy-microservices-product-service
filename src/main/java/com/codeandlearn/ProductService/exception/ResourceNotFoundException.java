package com.codeandlearn.ProductService.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {

	private String errorCode;
	
	public ResourceNotFoundException(String msg, String errorcode) {
		super(msg);
		this.errorCode = errorcode;
	}
}
